package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tbl_course_lessons")
public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lesson_id")
    private int lessonId;

    @Column(name="lesson_number")
    private int lessonNumber;

    @Column(name="lesson_name")
    private String lessonName;
    @Column(name="lesson_description")
    private String lessonDescription;


    @OneToOne()
    @JoinColumn(name="course_id")
    @JsonBackReference
    private Course course;


    @OneToOne(mappedBy = "lesson",cascade = CascadeType.ALL)
    @JsonBackReference
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
