package com.portfolio.ffperezs.controller;

import com.portfolio.ffperezs.dto.SkillDto;
import com.portfolio.ffperezs.entity.Skill;
import com.portfolio.ffperezs.exception.Mensaje;
import com.portfolio.ffperezs.service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = {"https://ffperezs.web.app","http://localhost:4200"})
public class SkillController {

    private final SkillService skillService;


    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    
    
    //Lista
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> getSkill(){
        List<Skill> skill = skillService.findSkill();
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    
    
    //Buscar por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    //Buscar por ID
    /*@GetMapping("/id/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id") int id ) {
        if(!skillService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.findSkillById(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);    
    }*/

    
    //Crear
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Skill> addSkill(@RequestBody SkillDto skillDto) {
        Skill newSkill = new Skill (
                skillDto.getNombre(),
                skillDto.getLogo(),
                skillDto.getPorcentaje()   
        );
        
        skillService.addSkill(newSkill);
        return new ResponseEntity<>(newSkill,HttpStatus.OK);
    }


    //Editar
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editSkill (@PathVariable("id") int id, @RequestBody SkillDto skillDto){
        if(!skillService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.findById(id).get();

        skill.setNombre(skillDto.getNombre());
        skill.setLogo(skillDto.getLogo());
        skill.setPorcentaje(skillDto.getPorcentaje());
              
        
        skillService.save(skill);
        return new ResponseEntity<>("Skill Actualizada.", HttpStatus.OK);
     }

    
    //Borrar
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") int id) {
        if(!skillService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        skillService.deleteSkill(id);
        return new ResponseEntity<>("Skill Eliminada.",HttpStatus.OK);
    }
}
