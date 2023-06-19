package com.portfolio.ffperezs.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String posicion;
    @NotNull
    private String sobreMi;
    @NotNull
    private String img;
    @NotNull
    private String banner;
    @NotNull
    private String linkW;
    @NotNull
    private String linkE;
    
    
    
    //Relación entre entidades y para que borre si la persona no existe
  
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Educacion> educacion; 
    
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Experiencia> experiencia; 
    
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Proyecto> proyecto; 
   
    @OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
    private List<Skill> skill;
    

    //constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String posicion, String sobreMi, String img, String banner, String linkW, String linkE) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
