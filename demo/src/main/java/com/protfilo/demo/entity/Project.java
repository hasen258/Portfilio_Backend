package com.protfilo.demo.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    }
