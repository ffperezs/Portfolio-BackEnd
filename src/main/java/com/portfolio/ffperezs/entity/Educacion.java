package com.portfolio.ffperezs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name= "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombreEdu")
    private String nombreEdu;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "logo")
    private String logo;
    @Column(name = "linkWeb")
    private String linkWeb;
    @Column(name = "inicio")
    private String inicio;
    @Column(name = "fin")
    private String fin;

    //Relación entre entidades
    
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid", insertable=false, updatable=false)
    //para que se borre si se borra la persona
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    private Long personaid;
    
    
    //Constructores
    public Educacion() {
    }

    public Educacion(String nombreEdu, String titulo, String logo, String linkWeb, String inicio, String fin) {
        this.nombreEdu = nombreEdu;
        this.titulo = titulo;
        this.logo = logo;
        this.linkWeb = linkWeb;
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Long personaid) {
        this.personaid = personaid;
    }
   
}
