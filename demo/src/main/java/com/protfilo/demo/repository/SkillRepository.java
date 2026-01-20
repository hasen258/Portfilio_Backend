package com.protfilo.demo.repository;

import com.protfilo.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsByName(String name);
    boolean existsByCategory(String category);
}
