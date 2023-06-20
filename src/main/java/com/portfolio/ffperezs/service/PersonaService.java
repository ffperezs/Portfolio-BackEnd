package com.portfolio.ffperezs.service;

import com.portfolio.ffperezs.entity.Persona;
import com.portfolio.ffperezs.exception.UserNotFoundException;
import com.portfolio.ffperezs.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona addPersona(Persona persona) {
        return personaRepository.save(persona);
    }
    

    public List<Persona> findPersona() {
        return personaRepository.findAll();
    }
    
    public Optional<Persona> findById(int id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona){
        return personaRepository.save(persona);
    }
    
    public Persona editPersona (Persona persona) {
        return personaRepository.save(persona);
    }
    
    public void deletePersona(int id) {
        personaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }
    
    public Persona findPersonaById(int id) {
        return personaRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Persona no encontrada"));
    }

    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }
}
