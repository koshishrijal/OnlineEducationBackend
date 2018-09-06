package com.asky.backend.model.ContentModel;

import com.asky.backend.entity.Course;

public class ContentDtoForInsert {
   // private int contentId;

    private String contentName;

    private String contentDescription;

    private String contentPdfLink;

    private String contentVdoLink;

   private int courseId;

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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
