
package com.portfolio.proyectofinalbcknd.Controller;

import Dto.DtoEstudio;
import com.portfolio.proyectofinalbcknd.Entity.Estudio;
import com.portfolio.proyectofinalbcknd.Security.Controller.Mensaje;
import com.portfolio.proyectofinalbcknd.Service.EstudioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estu")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudioController {
    @Autowired
    EstudioService estudioService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = estudioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!estudioService.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio experiencia = estudioService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoEst) {
        if (StringUtils.isBlank(dtoEst.getNombreE())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }
        if(estudioService.existsByNombreE(dtoEst.getNombreE())){
            return new ResponseEntity(new Mensaje("Estudio Duplicada"),
                    HttpStatus.BAD_REQUEST);
        }
        Estudio experiencia = new Estudio(dtoEst.getNombreE(), dtoEst.getDescripcionE(), dtoEst.getTiempoE());
        estudioService.save(experiencia);
        return new ResponseEntity(new Mensaje("Estudio Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoEst){
        if (!estudioService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe tal Id"), HttpStatus.BAD_REQUEST);
        }
        if (estudioService.existsByNombreE(dtoEst.getNombreE()) && estudioService.getByNombreE(dtoEst.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Estudio Duplicada"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEst.getNombreE())){
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Estudio estudio = estudioService.getOne(id).get();
        estudio.setNombreE(dtoEst.getNombreE());
        estudio.setDescripcionE(dtoEst.getDescripcionE());
        estudio.setTiempoE(dtoEst.getTiempoE());
        
        estudioService.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!estudioService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        estudioService.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminada"), HttpStatus.OK);  
    }

    
}
