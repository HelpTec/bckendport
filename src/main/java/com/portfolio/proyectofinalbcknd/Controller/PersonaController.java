package com.portfolio.proyectofinalbcknd.Controller;

import Dto.DtoPersona;
import com.portfolio.proyectofinalbcknd.Entity.Persona;
import com.portfolio.proyectofinalbcknd.Interface.IPersonaInterface;
import com.portfolio.proyectofinalbcknd.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "https://hosting-angular-portfolio.web.app")
public class PersonaController {

    @Autowired
    IPersonaInterface ipersonaService;

    //asi es como le digo al front que tiene que hacer
    //en este caso es de la BD al FRONT, cuando recibe de la url hace esto
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "Persona Creada";
    }

    //ahora para borrar con id, teniendo la id en su url
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "Persona Borrada";
    }

    //ahora le digo cuando editar a alguien teniendo el dato en la id
    //y las variables en el body
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoPersona dtopers){
        Persona pers = ipersonaService.findPersona(id);
        pers.setNombre(dtopers.getNombre());
        pers.setApellido(dtopers.getApellido());
        pers.setImg(dtopers.getImg());
        pers.setAbout(dtopers.getAbout());
        pers.setFacebook(dtopers.getFacebook());
        pers.setInstangram(dtopers.getInstangram());
        pers.setLinkedin(dtopers.getLinkedin());
        pers.setGithub(dtopers.getGithub());
        pers.setTwitter(dtopers.getTwitter());
        
        ipersonaService.savePersona(pers);
        return new ResponseEntity(new Mensaje("Perfil Actualizado"), HttpStatus.OK);
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
    }

    @GetMapping("personas/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") long id) {
        Persona persona = ipersonaService.findPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
