package com.portfolio.ffperezs.repository;

import com.portfolio.ffperezs.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
}
