package com.protfilo.demo.service;

import com.protfilo.demo.entity.Project;
import com.protfilo.demo.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //  GET ALL PROJECTS
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //  GET PROJECT BY ID (ID IN BODY)
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }

    //  CREATE PROJECT
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    //  UPDATE PROJECT
    public Project updateProject(Long id, Project newProject) {
        Project existingProject = getProjectById(id);

        existingProject.setName(newProject.getName());
        existingProject.setDescription(newProject.getDescription());
        existingProject.setUrlWeb(newProject.getUrlWeb());
        existingProject.setUrlImgProject(newProject.getUrlImgProject());
        existingProject.setStatus(newProject.getStatus());
        existingProject.setStartDate(newProject.getStartDate());

        return projectRepository.save(existingProject);
    }

    //  DELETE PROJECT
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id " + id);
        }
        projectRepository.deleteById(id);
    }
}
