
package com.portfolio.proyectofinalbcknd.Repository;

import com.portfolio.proyectofinalbcknd.Entity.SoftSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftSkillsRep extends JpaRepository<SoftSkills, Integer>{
    public Optional<SoftSkills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
}
