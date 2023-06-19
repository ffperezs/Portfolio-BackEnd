package com.portfolio.ffperezs.service;


import com.portfolio.ffperezs.entity.Experiencia;
import com.portfolio.ffperezs.exception.UserNotFoundException;
import com.portfolio.ffperezs.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {
    
    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    public Experiencia addExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public List<Experiencia> findExperiencia () {
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> findById(int id) {
        return experienciaRepository.findById(id);
    }

    public Experiencia save(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }
    
    public Experiencia editExperiencia (Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }
    
    public void deleteExperiencia (int id) {
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
         return experienciaRepository.existsById(id);
     }
    
    public Experiencia findExperienciaById(int id) {
        return experienciaRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Experiencia no encontrada"));
    }

    public Optional<Experiencia> getOne(int id){
         return experienciaRepository.findById(id);
     }
}
