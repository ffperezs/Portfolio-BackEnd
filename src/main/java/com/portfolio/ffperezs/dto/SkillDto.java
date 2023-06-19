package com.portfolio.ffperezs.dto;

public class SkillDto {

    private String nombre;
    private String logo;
    private Integer porcentaje;

    
    //Constructores

    public SkillDto() {
    }

    public SkillDto(String nombre, String logo, Integer porcentaje) {
        this.nombre = nombre;
        this.logo = logo;
        this.porcentaje = porcentaje;
    }
    
    
    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
