
package com.portfolio.proyectofinalbcknd.Controller;

import Dto.DtoHardSkills;
import com.portfolio.proyectofinalbcknd.Entity.HardSkills;
import com.portfolio.proyectofinalbcknd.Security.Controller.Mensaje;
import com.portfolio.proyectofinalbcknd.Service.HardSkillsService;
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
@RequestMapping("hSkills")
@CrossOrigin(origins = "https://hosting-angular-portfolio.web.app")
public class HardSkillsController {
    @Autowired
    HardSkillsService hSServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardSkills>> list() {
        List<HardSkills> list = hSServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkills> getById(@PathVariable("id") int id){
        if(!hSServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HardSkills skill = hSServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardSkills DtoSki) {
        if (StringUtils.isBlank(DtoSki.getNombreS())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }
        if(hSServ.existsByNombreS(DtoSki.getNombreS())){
            return new ResponseEntity(new Mensaje("Habilidad Dura Duplicada"),
                    HttpStatus.BAD_REQUEST);
        }
        HardSkills skill = new HardSkills(DtoSki.getNombreS(), DtoSki.getNivelS(), DtoSki.getIconoS());
        hSServ.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad Dura Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardSkills DtoSki){
        if (!hSServ.existById(id)){
            return new ResponseEntity(new Mensaje("No existe tal Id"), HttpStatus.BAD_REQUEST);
        }
        if (hSServ.existsByNombreS(DtoSki.getNombreS()) && hSServ.getByNombreS(DtoSki.getNombreS()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Habilidad Dura Duplicada"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DtoSki.getNombreS())){
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        HardSkills skill = hSServ.getOne(id).get();
        skill.setNombreS(DtoSki.getNombreS());
        skill.setNivelS(DtoSki.getNivelS());
        skill.setIconoS(DtoSki.getIconoS());
        
        hSServ.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad Dura Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!hSServ.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        hSServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Dura eliminada"), HttpStatus.OK);  
    }

    
}