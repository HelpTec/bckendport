package com.portfolio.proyectofinalbcknd.Controller;

import Dto.DtoProyectos;
import com.portfolio.proyectofinalbcknd.Entity.Proyectos;
import com.portfolio.proyectofinalbcknd.Security.Controller.Mensaje;
import com.portfolio.proyectofinalbcknd.Service.ProyectoService;
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
@RequestMapping("proy")
@CrossOrigin(origins = "https://hosting-angular-portfolio.web.app")
public class ProyectosController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        } else {
            Proyectos proyecto = proyectoService.getOne(id).get();
            return new ResponseEntity(proyecto, HttpStatus.OK);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProy) {
        if (StringUtils.isBlank(dtoProy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Campos Incompletos"), HttpStatus.EXPECTATION_FAILED);
        }
        if (proyectoService.existByNombreP(dtoProy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Proyecto Duplicado"), HttpStatus.BAD_REQUEST);
        } else {
            Proyectos proy = new Proyectos(dtoProy.getNombreP(), dtoProy.getDescripcionP(), dtoProy.getImagenP(), dtoProy.getUrlP());
            proyectoService.save(proy);
            return new ResponseEntity(new Mensaje("Tarjeta Agregada"), HttpStatus.OK);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProy) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoService.existByNombreP(dtoProy.getNombreP()) && proyectoService.getByNombreP(dtoProy.getNombreP()).
                get().getId() != id) {
            return new ResponseEntity(new Mensaje("Proyecto Duplicado"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProy.getNombreP())) {
            return new ResponseEntity(new Mensaje("Campos Incompletos"), HttpStatus.EXPECTATION_FAILED);
        } else {
            Proyectos proy = proyectoService.getOne(id).get();
            proy.setNombreP(dtoProy.getNombreP());
            proy.setDescripcionP(dtoProy.getDescripcionP());
            proy.setImagenP(dtoProy.getImagenP());
            proy.setUrlP(dtoProy.getUrlP());

            proyectoService.save(proy);
            return new ResponseEntity(new Mensaje("Proyecto Editado"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id No Encontrada"), HttpStatus.BAD_REQUEST);
        } else {
            proyectoService.delete(id);
            return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
        }
    }
}
