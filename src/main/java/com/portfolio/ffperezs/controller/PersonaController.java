package com.portfolio.ffperezs.controller;

import com.portfolio.ffperezs.dto.PersonaDto;
import com.portfolio.ffperezs.entity.Persona;
import com.portfolio.ffperezs.exception.Mensaje;
import com.portfolio.ffperezs.service.PersonaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://Portfolio-ffperezs.web.app","http://localhost:4200"})
public class PersonaController {
    private final PersonaService personaService;


    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    
   //Lista
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> getPersona(){
        List<Persona> persona = personaService.findPersona();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    //Buscar por ID
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable("id") int id ) {
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.findPersonaById(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }*/
    
    /*//Crear
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> addPersona(@RequestBody PersonaDto personaDto){
        
        Persona persona = new Persona(
                personaDto.getNombre(), 
                personaDto.getApellido(),
                personaDto.getPosicion(),
                personaDto.getSobreMi(),
                personaDto.getImg(),
                personaDto.getBanner(),
                personaDto.getLinkW(),
                personaDto.getLinkE());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("La Persona ha sido creada Correctamente"), HttpStatus.OK);           
    }*/
    
    
    //Editar
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editPersona (@PathVariable("id") int id, @RequestBody PersonaDto personaDto){
        //Validamos si existe el ID
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID No existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.findById(id).get();

        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setPosicion(personaDto.getPosicion());
        persona.setSobreMi(personaDto.getSobreMi());
        persona.setImg(personaDto.getImg());
        persona.setLinkW(personaDto.getLinkW());
        persona.setLinkE(personaDto.getLinkE());
        
        personaService.save(persona);
        return new ResponseEntity<>("Persona Actualizada.", HttpStatus.OK);
     }
    
    
    /*
    //Borrar (por el momento no la usamos porque no vamos a eliminar la persona creada)
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        personaService.deletePersona(id);
        return  new ResponseEntity<>("La Persona ha sido eliminada correctamente", HttpStatus.OK);
    }  */
}
