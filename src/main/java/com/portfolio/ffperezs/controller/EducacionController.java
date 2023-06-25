package com.portfolio.ffperezs.controller;


import com.portfolio.ffperezs.dto.EducacionDto;
import com.portfolio.ffperezs.entity.Educacion;
import com.portfolio.ffperezs.exception.Mensaje;
import com.portfolio.ffperezs.service.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://ffperezs.web.app","http://localhost:4200"})
public class EducacionController {

    private final EducacionService educacionService;


    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    
    
    //Lista
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> educacion = educacionService.findEducacion();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    //Buscar por ID
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Educacion> getEducacion(@PathVariable("id") int id ) {
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.findEducacionById(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }*/

    
    //Crear
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Educacion> addEducacion(@RequestBody EducacionDto educacionDto) {
        Educacion newEducacion = new Educacion (
                educacionDto.getNombreEdu(),
                educacionDto.getTitulo(),
                educacionDto.getLogo(),
                educacionDto.getLinkWeb(),
                educacionDto.getInicio(),
                educacionDto.getFin()
        );
        educacionService.addEducacion(newEducacion);
        return new ResponseEntity<>(newEducacion,HttpStatus.OK);
    }


    //Editar
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editEducacion (@PathVariable("id") int id, @RequestBody EducacionDto educacionDto){
        //Validamos si existe el ID
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID No existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.findById(id).get();

        educacion.setNombreEdu(educacionDto.getNombreEdu());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setLogo(educacionDto.getLogo());
        educacion.setLinkWeb(educacionDto.getLinkWeb());
        educacion.setInicio(educacionDto.getInicio());
        educacion.setFin(educacionDto.getFin());
        
        
        educacionService.save(educacion);
        return new ResponseEntity<>("Educacion Actualizada.", HttpStatus.OK);
     }

    
    //Borrar
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") int id) {
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>("Educacion Eliminada.",HttpStatus.OK);
    }
}
