package com.protfilo.demo.controller;

import com.protfilo.demo.entity.Project;
import com.protfilo.demo.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //  GET ALL PROJECTS
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    //  GET PROJECT BY ID
    @GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    //  CREATE PROJECT
    @PostMapping("/project")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // UPDATE PROJECT
    @PutMapping("/update/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    //  DELETE PROJECT
    @DeleteMapping("/delete/{id}")
    public org.springframework.http.ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }
}
