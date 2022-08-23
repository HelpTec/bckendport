package Dto;

import javax.validation.constraints.NotBlank;


public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String about;
    @NotBlank
    private String facebook;
    @NotBlank
    private String instangram;
    @NotBlank
    private String linkedin;
    @NotBlank
    private String github;
    @NotBlank
    private String twitter;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img, String about, String facebook, String instangram, String linkedin, String github, String twitter) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.about = about;
        this.facebook = facebook;
        this.instangram = instangram;
        this.linkedin = linkedin;
        this.github = github;
        this.twitter = twitter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstangram() {
        return instangram;
    }

    public void setInstangram(String instangram) {
        this.instangram = instangram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    
}
