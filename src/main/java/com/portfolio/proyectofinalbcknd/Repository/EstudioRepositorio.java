
package com.portfolio.proyectofinalbcknd.Repository;

import com.portfolio.proyectofinalbcknd.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepositorio extends JpaRepository<Estudio, Integer> {
    public Optional<Estudio> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
