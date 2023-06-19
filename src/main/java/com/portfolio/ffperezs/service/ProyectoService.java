package com.portfolio.ffperezs.service;

import com.portfolio.ffperezs.entity.Proyecto;
import com.portfolio.ffperezs.exception.UserNotFoundException;
import com.portfolio.ffperezs.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProyectoService {
    
    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto addProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> findProyecto () {
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyecto> findById(int id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
    
    public Proyecto editProyecto (Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
    
    public void deleteProyecto (int id) {
        proyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
         return proyectoRepository.existsById(id);
     }
    
    public Proyecto findProyectoById(int id) {
        return proyectoRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Experiencia no encontrada"));
    }
    
    public Optional<Proyecto> getOne(int id){
         return proyectoRepository.findById(id);
     }
}
