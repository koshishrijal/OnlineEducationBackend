package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="tbl_lesson_topics")
public class Topic implements Serializable {
    @Column(name="topic_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    @Column(name="topic_name")
    private String topicName;

    @Column(name="topic_description")
    private String topicDescription;

    @Column(name="topic_number")
    private int topicNumber;

    @OneToOne()
    @JoinColumn(name="lesson_id")
    @JsonBackReference
    private Lesson lesson;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public int getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(int topicNumber) {
        this.topicNumber = topicNumber;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
