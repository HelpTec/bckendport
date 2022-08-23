
package com.portfolio.proyectofinalbcknd.Interface;

import com.portfolio.proyectofinalbcknd.Entity.Persona;
import java.util.List;

public interface IPersonaInterface {
    //Metodo para hacer la lista
    public List<Persona> getPersona();
    
    //guardar el objeto persona
    public void savePersona(Persona persona);
    
    //borrar
    public void deletePersona(Long id);
    
    //buscar
    public Persona findPersona(Long id);
}
