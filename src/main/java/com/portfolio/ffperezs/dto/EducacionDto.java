package com.portfolio.ffperezs.dto;

public class EducacionDto {

    private String nombreEdu;
    private String titulo;
    private String logo;
    private String linkWeb;
    private String inicio;
    private String fin;

    
    //Constructores
    
    public EducacionDto() {
    }
   

    public EducacionDto(String nombreEdu, String titulo, String logo, String linkWeb, String inicio, String fin) {
        this.nombreEdu = nombreEdu;
        this.titulo = titulo;
        this.logo = logo;
        this.linkWeb = linkWeb;
        this.inicio = inicio;
        this.fin = fin;
    }

    //Getter y Setter

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
