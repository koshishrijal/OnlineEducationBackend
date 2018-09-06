package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tbl_faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="faculty_id")
    private int facultyId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
