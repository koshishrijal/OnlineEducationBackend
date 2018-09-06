package com.asky.backend.model.CourseModel;


import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

public class CourseDtoForInsert {
    @NotNull
    private String courseName;
    @NotNull
    private String description;
    @NotNull
    private boolean status;

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
