
package com.portfolio.proyectofinalbcknd.Security.Service;

import com.portfolio.proyectofinalbcknd.Security.Repository.iRolRepository;
import com.portfolio.proyectofinalbcknd.Security.Enums.RolNombre;
import com.portfolio.proyectofinalbcknd.Security.Rol;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
    @Autowired iRolRepository iRolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepo.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol){
        iRolRepo.save(rol);
    }
}