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
@Table(name = "Proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombrePro")
    private String nombrePro;
    @Column(name = "linkGit")
    private String linkGit;
    @Column(name = "linkPro")
    private String linkPro;
    @Column(name = "img")
    private String img;

    
    //Relación entre entidades
    
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid", insertable=false, updatable=false)
    //para que se borre si se borra la persona
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    private Long personaid;
    
    
    //Constructores
    public Proyecto() {
    }

    public Proyecto(String nombrePro, String linkGit, String linkPro, String img) {
        this.nombrePro = nombrePro;
        this.linkGit = linkGit;
        this.linkPro = linkPro;
        this.img = img;
    }
    
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
