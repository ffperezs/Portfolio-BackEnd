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
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombreExp")
    private String nombreExp;
    @Column (name = "puesto")
    private String puesto;
    @Column (name = "logo")
    private String logo;
    @Column(name = "linkWeb")
    private String linkWeb;
    @Column(name = "inicio")
    private String inicio;
    @Column(name = "fin")
    private String fin;
    @Column(name = "tarea1")
    private String tarea1;
    @Column(name = "tarea2")
    private String tarea2;
    @Column(name = "tarea3")
    private String tarea3;
    
    
    //Relación entre entidades
    
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid", insertable=false, updatable=false)
    //para que se borre si se borra la persona
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    private Long personaid;
    
    
    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreExp, String puesto, String logo, String linkWeb, String inicio, String fin, String tarea1, String tarea2, String tarea3) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
