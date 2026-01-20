package com.protfilo.demo.service;

import com.protfilo.demo.entity.Skill;
import com.protfilo.demo.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    public Skill create(Skill skill) {
        if (skillRepository.existsByName(skill.getName())) {
            throw new RuntimeException("Skill already exists");
        }
        return skillRepository.save(skill);
    }

    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
    public Map<String, List<Skill>> getGroupedByCategory() {
        return skillRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Skill::getCategory));
    }

}
