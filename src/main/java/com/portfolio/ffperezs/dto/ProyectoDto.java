package com.portfolio.ffperezs.dto;

public class ProyectoDto {

    private String nombrePro;
    private String linkGit;
    private String linkPro;
    private String img;

    
    //Constructores

    public ProyectoDto() {
    }

    public ProyectoDto(String nombrePro, String linkGit, String linkPro, String img) {
        this.nombrePro = nombrePro;
        this.linkGit = linkGit;
        this.linkPro = linkPro;
        this.img = img;
    }
    
    
    //Getter y Setter

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getLinkGit() {
        return linkGit;
    }

    public void setLinkGit(String linkGit) {
        this.linkGit = linkGit;
    }

    public String getLinkPro() {
        return linkPro;
    }

    public void setLinkPro(String linkPro) {
        this.linkPro = linkPro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
