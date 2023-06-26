package com.portfolio.ffperezs.controller;

import com.portfolio.ffperezs.dto.ProyectoDto;
import com.portfolio.ffperezs.entity.Proyecto;
import com.portfolio.ffperezs.exception.Mensaje;
import com.portfolio.ffperezs.service.ProyectoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://Portfolio-ffperezs.web.app","http://localhost:4200"})
public class ProyectoController {

    private final ProyectoService proyectoService;


    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }
    
    
    //Lista
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> getProyecto(){
        List<Proyecto> proyecto = proyectoService.findProyecto();
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    //Buscar por ID
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Proyecto> getProyecto(@PathVariable("id") int id ) {
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.findProyectoById(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);  
    }*/

    
    //Crear
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Proyecto> addProyecto(@RequestBody ProyectoDto proyectoDto) {
        Proyecto newProyecto = new Proyecto (
                proyectoDto.getNombrePro(),
                proyectoDto.getLinkGit(),
                proyectoDto.getLinkPro(),
                proyectoDto.getImg()    
        );
        
        proyectoService.addProyecto(newProyecto);
        return new ResponseEntity<>(newProyecto,HttpStatus.OK);
    }


    //Editar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editProyecto (@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto){
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.findById(id).get();

        proyecto.setNombrePro(proyectoDto.getNombrePro());
        proyecto.setLinkGit(proyectoDto.getLinkGit());
        proyecto.setLinkPro(proyectoDto.getLinkPro());
        proyecto.setImg(proyectoDto.getImg());      
        
        proyectoService.save(proyecto);
        return new ResponseEntity<>("Proyecto Actualizado.", HttpStatus.OK);
     }

    
    //Borrar
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable("id") int id) {
        if(!proyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        proyectoService.deleteProyecto(id);
        return new ResponseEntity<>("Proyecto Eliminado.",HttpStatus.OK);
    }
}
