package Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String tiempoE;
    
    //Construct

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String tiempoE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.tiempoE = tiempoE;
    }
    
    //gettersSetters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getTiempoE() {
        return tiempoE;
    }

    public void setTiempoE(String tiempoE) {
        this.tiempoE = tiempoE;
    }
    
    
}
