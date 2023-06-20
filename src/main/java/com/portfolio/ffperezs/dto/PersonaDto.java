package com.portfolio.ffperezs.dto;

import javax.validation.constraints.NotBlank;

public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String posicion;
    @NotBlank
    private String sobreMi;
    @NotBlank
    private String img;
    @NotBlank
    private String banner;    
    @NotBlank
    private String linkW;
    @NotBlank
    private String linkE;
    
    
   //Constructor

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String posicion, String sobreMi, String img, String banner, String linkW, String linkE) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.sobreMi = sobreMi;
        this.img = img;
        this.banner = banner;
        this.linkW = linkW;
        this.linkE = linkE;
    }
   
    //Getter y Setter

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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
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

    public String getLinkW() {
        return linkW;
    }

    public void setLinkW(String linkW) {
        this.linkW = linkW;
    }

    public String getLinkE() {
        return linkE;
    }

    public void setLinkE(String linkE) {
        this.linkE = linkE;
    }
    
    
}
