package com.portfolio.proyectofinalbcknd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "Introduzca Valor entre 1 y 50 caracteres")
    private String Nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "Introduzca Valor entre 1 y 50 caracteres")
    private String Apellido;
    @Size(min = 1, max = 1000, message = "Introduzca texto entre 1 y 1000 caracteres")
    private String img;
    @Size(min = 1, max = 1000, message = "Introduzca texto entre 1 y 1000 caracteres")
    private String banner;
    @Size(min = 1, max = 1000, message = "Introduzca texto entre 1 y 1000 caracteres")
        private String about;
    @Size(min = 1, max = 150, message = "Introduzca texto entre 1 y 50 caracteres")
    private String facebook;
    @Size(min = 1, max = 150, message = "Introduzca texto entre 1 y 50 caracteres")
    private String instangram;
    @Size(min = 1, max = 150, message = "Introduzca texto entre 1 y 50 caracteres")
    private String linkedin;
    @Size(min = 1, max = 150, message = "Introduzca texto entre 1 y 50 caracteres")
    private String github;
    @Size(min = 1, max = 150, message = "Introduzca texto entre 1 y 50 caracteres")
    private String twitter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
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
