package com.portfolio.ffperezs.controller;

import com.portfolio.ffperezs.dto.ExperienciaDto;
import com.portfolio.ffperezs.entity.Experiencia;
import com.portfolio.ffperezs.exception.Mensaje;
import com.portfolio.ffperezs.service.ExperienciaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://ffperezs.web.app","http://localhost:4200"})
public class ExperienciaController {

    private final ExperienciaService experienciaService;


    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }
    
    
    //Lista
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> getExperiencia(){
        List<Experiencia> experiencia = experienciaService.findExperiencia();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Experiencia> getExperiencia(@PathVariable("id") int id ) {
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.findExperienciaById(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
        
    }*/

    
    //Crear
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Experiencia> addExperiencia(@RequestBody ExperienciaDto experienciaDto) {
        Experiencia newExperiencia = new Experiencia (
                experienciaDto.getNombreExp(),
                experienciaDto.getPuesto(),
                experienciaDto.getLogo(),
                experienciaDto.getLinkWeb(),
                experienciaDto.getInicio(),
                experienciaDto.getFin(),
                experienciaDto.getTarea1(),
                experienciaDto.getTarea2(),
                experienciaDto.getTarea3()        
        );
        
        experienciaService.addExperiencia(newExperiencia);
        return new ResponseEntity<>(newExperiencia,HttpStatus.OK);
    }


    //Editar
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto){
        //Validamos si existe el ID
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID No existe"), HttpStatus.BAD_REQUEST);
         
        Experiencia experiencia = experienciaService.getOne(id).get();

        experiencia.setNombreExp(experienciaDto.getNombreExp());
        experiencia.setPuesto(experienciaDto.getPuesto());
        experiencia.setLogo(experienciaDto.getLogo());
        experiencia.setLinkWeb(experienciaDto.getLinkWeb());
        experiencia.setInicio(experienciaDto.getInicio());
        experiencia.setFin(experienciaDto.getFin());
        experiencia.setTarea1(experienciaDto.getTarea1());
        experiencia.setTarea2(experienciaDto.getTarea2());
        experiencia.setTarea3(experienciaDto.getTarea3());
        
        
        experienciaService.save(experiencia);
            return new ResponseEntity(new Mensaje("Experiencia Actualizada."), HttpStatus.OK);
 
     }
    
    

    
    //Borrar
    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") int id) {
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity<>("Experiencia Eliminada.",HttpStatus.OK);
    }
    
}
