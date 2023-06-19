package com.portfolio.ffperezs.dto;

public class ExperienciaDto {
    private String nombreExp;
    private String puesto;
    private String logo;
    private String linkWeb;
    private String inicio;
    private String fin;
    private String tarea1;
    private String tarea2;
    private String tarea3;
    
    //Constructores

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String puesto, String logo, String linkWeb, String inicio, String fin, String tarea1, String tarea2, String tarea3) {
        this.nombreExp = nombreExp;
        this.puesto = puesto;
        this.logo = logo;
        this.linkWeb = linkWeb;
        this.inicio = inicio;
        this.fin = fin;
        this.tarea1 = tarea1;
        this.tarea2 = tarea2;
        this.tarea3 = tarea3;
    }
    
    //Getter y Setter

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public String getTarea1() {
        return tarea1;
    }

    public void setTarea1(String tarea1) {
        this.tarea1 = tarea1;
    }

    public String getTarea2() {
        return tarea2;
    }

    public void setTarea2(String tarea2) {
        this.tarea2 = tarea2;
    }

    public String getTarea3() {
        return tarea3;
    }

    public void setTarea3(String tarea3) {
        this.tarea3 = tarea3;
    }
    
}
