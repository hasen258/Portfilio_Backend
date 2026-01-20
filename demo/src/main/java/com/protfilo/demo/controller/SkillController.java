package com.protfilo.demo.controller;

import com.protfilo.demo.entity.Skill;
import com.protfilo.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // PUBLIC
    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    // AUTH REQUIRED
    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return skillService.create(skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.delete(id);
    }

    @GetMapping("/grouped")
    public Map<String, List<Skill>> getGroupedSkills() {
        return skillService.getGroupedByCategory();
    }

}
