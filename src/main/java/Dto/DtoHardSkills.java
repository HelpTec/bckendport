
package Dto;

import javax.validation.constraints.NotBlank;

public class DtoHardSkills {
    @NotBlank
    private String nombreS;
    @NotBlank
    private int nivelS;
    @NotBlank
    private String iconoS;

    public DtoHardSkills() {
    }

    public DtoHardSkills(String nombreS, int nivelS, String iconoS) {
        this.nombreS = nombreS;
        this.nivelS = nivelS;
        this.iconoS = iconoS;
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
