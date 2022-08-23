
package com.portfolio.proyectofinalbcknd.Service;

import com.portfolio.proyectofinalbcknd.Entity.HardSkills;
import com.portfolio.proyectofinalbcknd.Repository.HardSkillsRep;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HardSkillsService {
    
    @Autowired
    HardSkillsRep hSrep;
    
    public List<HardSkills> list() {
        return hSrep.findAll();
    }
    
    public Optional<HardSkills> getOne(int id) {
        return hSrep.findById(id);
    }

    public Optional<HardSkills> getByNombreS(String nombreS) {
        return hSrep.findByNombreS(nombreS);
    }
    
    public void save(HardSkills hS){
        hSrep.save(hS);
    }
    
    public void delete(int id){
        hSrep.deleteById(id);
    }
    
    public boolean existById(int id){
        return hSrep.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return hSrep.existsByNombreS(nombreS);
    }
}
