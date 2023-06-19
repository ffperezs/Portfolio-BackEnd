package com.portfolio.ffperezs.service;

import com.portfolio.ffperezs.entity.Educacion;
import com.portfolio.ffperezs.exception.UserNotFoundException;
import com.portfolio.ffperezs.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionService {

    private final EducacionRepository educacionRepository;

    @Autowired
    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }

    public Educacion addEducacion (Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    public List<Educacion> findEducacion () {
        return educacionRepository.findAll();
    }

    public Optional<Educacion> findById(int id) {
        return educacionRepository.findById(id);
    }

    public Educacion save(Educacion educacion){
        return educacionRepository.save(educacion);
    }
    
    public Educacion editEducacion (Educacion educacion) {
        return educacionRepository.save(educacion);
    }
    
    public void deleteEducacion (int id) {
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public Educacion findEducacionById(int id) {
        return educacionRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Educacion no encontrada"));
    }
    
    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }
}
