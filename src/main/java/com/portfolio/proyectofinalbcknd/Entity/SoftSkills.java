package com.portfolio.proyectofinalbcknd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SoftSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nombreS;
    private int nivelS;
    private String iconoS;

    public SoftSkills() {
    }

    public SoftSkills(String nombreS, int nivelS, String iconoS) {
        this.nombreS = nombreS;
        this.nivelS = nivelS;
        this.iconoS = iconoS;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getNivelS() {
        return nivelS;
    }

    public void setNivelS(int nivelS) {
        this.nivelS = nivelS;
    }

    public String getIconoS() {
        return iconoS;
    }

    public void setIconoS(String iconoS) {
        this.iconoS = iconoS;
    }
    
    
        
}
