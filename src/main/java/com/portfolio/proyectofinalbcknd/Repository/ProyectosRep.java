package com.portfolio.proyectofinalbcknd.Repository;

import com.portfolio.proyectofinalbcknd.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRep extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos>findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
    
}
