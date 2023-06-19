package com.portfolio.ffperezs.repository;

import com.portfolio.ffperezs.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
}
