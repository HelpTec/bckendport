
package com.portfolio.proyectofinalbcknd.Security.Repository;

import com.portfolio.proyectofinalbcknd.Security.Enums.RolNombre;
import com.portfolio.proyectofinalbcknd.Security.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}