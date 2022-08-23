package com.portfolio.proyectofinalbcknd.Service;

import com.portfolio.proyectofinalbcknd.Entity.Proyectos;
import com.portfolio.proyectofinalbcknd.Repository.ProyectosRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    ProyectosRep proyectoRep;
    
    public List<Proyectos>list(){
        return proyectoRep.findAll();
    }
    
    public Optional<Proyectos>getOne(int id){
        return proyectoRep.findById(id);        
    }
    
    public Optional<Proyectos>getByNombreP(String nombreP){
        return proyectoRep.findByNombreP(nombreP);
    }
    
    public void save(Proyectos proy){
        proyectoRep.save(proy);
    }
    
    public void delete(int id){
        proyectoRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectoRep.existsById(id);
    }
    
    public boolean existByNombreP(String nombreP){
        return proyectoRep.existsByNombreP(nombreP);
    }
    
}
