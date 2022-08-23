package com.portfolio.proyectofinalbcknd.Service;

import com.portfolio.proyectofinalbcknd.Entity.SoftSkills;
import com.portfolio.proyectofinalbcknd.Repository.SoftSkillsRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillsService {
    
    @Autowired
    SoftSkillsRep sSrep;
    
    public List<SoftSkills> list() {
        return sSrep.findAll();
    }
    
    public Optional<SoftSkills> getOne(int id) {
        return sSrep.findById(id);
    }

    public Optional<SoftSkills> getByNombreS(String nombreS) {
        return sSrep.findByNombreS(nombreS);
    }
    
    public void save(SoftSkills hS){
        sSrep.save(hS);
    }
    
    public void delete(int id){
        sSrep.deleteById(id);
    }
    
    public boolean existById(int id){
        return sSrep.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return sSrep.existsByNombreS(nombreS);
    }
}