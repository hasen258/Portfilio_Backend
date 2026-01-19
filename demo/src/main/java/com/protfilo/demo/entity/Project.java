package com.protfilo.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "url_web")
    private String urlWeb;

    @Column(name = "url_img_project")
    private String urlImgProject;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    // ===== Constructors =====

    public Project() {
    }

    public Project(String name, String description, String urlWeb, String urlImgProject, String status, LocalDate startDate) {
        this.name = name;
        this.description = description;
        this.urlWeb = urlWeb;
        this.urlImgProject = urlImgProject;
        this.status = status;
        this.startDate = startDate;
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getUrlImgProject() {
        return urlImgProject;
    }

    public void setUrlImgProject(String urlImgProject) {
        this.urlImgProject = urlImgProject;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
