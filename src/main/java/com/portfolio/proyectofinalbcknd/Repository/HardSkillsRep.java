package com.portfolio.proyectofinalbcknd.Repository;

import com.portfolio.proyectofinalbcknd.Entity.HardSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HardSkillsRep extends JpaRepository<HardSkills, Integer>{
    public Optional<HardSkills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
}
