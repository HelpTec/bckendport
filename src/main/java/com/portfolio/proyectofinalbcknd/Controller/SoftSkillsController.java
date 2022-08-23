package com.portfolio.proyectofinalbcknd.Controller;

import Dto.DtoSoftSkills;
import com.portfolio.proyectofinalbcknd.Entity.SoftSkills;
import com.portfolio.proyectofinalbcknd.Security.Controller.Mensaje;
import com.portfolio.proyectofinalbcknd.Service.SoftSkillsService;
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
@RequestMapping("sSkills")
@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillsController {
    @Autowired
    SoftSkillsService sSServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<SoftSkills>> list() {
        List<SoftSkills> list = sSServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SoftSkills> getById(@PathVariable("id") int id){
        if(!sSServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SoftSkills skill = sSServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSoftSkills DtoSki) {
        if (StringUtils.isBlank(DtoSki.getNombreS())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }
        if(sSServ.existsByNombreS(DtoSki.getNombreS())){
            return new ResponseEntity(new Mensaje("Habilidad Blanda Duplicada"),
                    HttpStatus.BAD_REQUEST);
        }
        SoftSkills skill = new SoftSkills(DtoSki.getNombreS(), DtoSki.getNivelS(), DtoSki.getIconoS());
        sSServ.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad Blanda Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSoftSkills DtoSki){
        if (!sSServ.existById(id)){
            return new ResponseEntity(new Mensaje("No existe tal Id"), HttpStatus.BAD_REQUEST);
        }
        if (sSServ.existsByNombreS(DtoSki.getNombreS()) && sSServ.getByNombreS(DtoSki.getNombreS()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Habilidad Blanda Duplicada"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(DtoSki.getNombreS())){
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        SoftSkills skill = sSServ.getOne(id).get();
        skill.setNombreS(DtoSki.getNombreS());
        skill.setNivelS(DtoSki.getNivelS());
        skill.setIconoS(DtoSki.getIconoS());
        
        sSServ.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad Blanda Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSServ.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        sSServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Blanda eliminada"), HttpStatus.OK);  
    }

    
}