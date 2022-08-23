
package com.portfolio.proyectofinalbcknd.Security.Service;

import com.portfolio.proyectofinalbcknd.Security.Entity.Usuario;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.proyectofinalbcknd.Security.Repository.iUsuarioRepository;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired iUsuarioRepository iUsuarioRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iUsuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iUsuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iUsuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iUsuarioRepo.save(usuario);
    }
}