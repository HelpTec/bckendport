
package com.portfolio.proyectofinalbcknd.Service;

import com.portfolio.proyectofinalbcknd.Entity.Estudio;
import com.portfolio.proyectofinalbcknd.Repository.EstudioRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstudioService {
    
    @Autowired
    EstudioRepositorio estudioRepositorio;
    
    public List<Estudio> list() {
        return estudioRepositorio.findAll();
    }
    
    public Optional<Estudio> getOne(int id) {
        return estudioRepositorio.findById(id);
    }

    public Optional<Estudio> getByNombreE(String nombreE) {
        return estudioRepositorio.findByNombreE(nombreE);
    }
    
    public void save(Estudio est){
        estudioRepositorio.save(est);
    }
    
    public void delete(int id){
        estudioRepositorio.deleteById(id);
    }
    
    public boolean existById(int id){
        return estudioRepositorio.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return estudioRepositorio.existsByNombreE(nombreE);
    }
}
