package com.protfilo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String logo;

    @Column(nullable = false)
    private String category;

    // Constructors
    public Skill() {
    }

    public Skill(String name, String category) {
        this.name = name;
        this.category = category;
    }
}