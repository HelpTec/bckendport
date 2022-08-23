package Dto;

import javax.validation.constraints.NotBlank;

public class DtoSoftSkills {
    @NotBlank
    private String NombreS;
    @NotBlank
    private int nivelS;
    @NotBlank
    private String iconoS;

    public DtoSoftSkills() {
    }

    public DtoSoftSkills(String NombreS, int nivelS, String iconoS) {
        this.NombreS = NombreS;
        this.nivelS = nivelS;
        this.iconoS = iconoS;
    }

    public String getNombreS() {
        return NombreS;
    }

    public void setNombreS(String NombreS) {
        this.NombreS = NombreS;
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
