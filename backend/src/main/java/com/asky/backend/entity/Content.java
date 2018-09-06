package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="tbl_content")
public class Content  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="content_id")
    private int contentId;

    @Column(name="content_name")
    private String contentName;

    @Column(name="content_description")
    private String contentDescription;

    @Column(name="content_pdf_link")
    private String contentPdfLink;

    @Column(name="content_vdo_link")
    private String contentVdoLink;

    @ManyToOne()
    @JoinColumn(name="course_id")
    @JsonBackReference
    private Course course;


    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getContentPdfLink() {
        return contentPdfLink;
    }

    public void setContentPdfLink(String contentPdfLink) {
        this.contentPdfLink = contentPdfLink;
    }

    public String getContentVdoLink() {
        return contentVdoLink;
    }

    public void setContentVdoLink(String contentVdoLink) {
        this.contentVdoLink = contentVdoLink;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

