package com.portfolio.ffperezs.service;


import com.portfolio.ffperezs.entity.Skill;
import com.portfolio.ffperezs.exception.UserNotFoundException;
import com.portfolio.ffperezs.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> findSkill () {
        return skillRepository.findAll();
    }
    
    public Optional<Skill> findById(int id) {
        return skillRepository.findById(id);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }
    
    public Skill editSkill (Skill skill) {
        return skillRepository.save(skill);
    }
    
    public void deleteSkill (int id) {
        skillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
         return skillRepository.existsById(id);
     }
    
    public Skill findSkillById(int id) {
        return skillRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Skill no encontrada"));
    }
    
    public Optional<Skill> getOne(int id){
         return skillRepository.findById(id);
     }
}
