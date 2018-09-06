package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="tbl_course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private int courseId;
    @Column(name="course_name")
    private String courseName;
    @Column(name="description")
    private String description;
    @Column(name="status")
    private boolean status;

    @OneToOne(mappedBy="course",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Lesson lesson;

    @OneToMany(mappedBy="course",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UserHasCourse> userHasCourseList;

    @OneToMany(mappedBy="course" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Content> contentList;

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public List<UserHasCourse> getUserHasCourseList() {
        return userHasCourseList;
    }

    public void setUserHasCourseList(List<UserHasCourse> userHasCourseList) {
        this.userHasCourseList = userHasCourseList;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
