package com.asky.backend.model.EnrollmentModel;

import javax.validation.constraints.NotNull;

public class EnrollmentDtoForInsert {

    @NotNull(message = "course id is required")
    private int courseId;

    @NotNull(message="user id is required")
    private int userId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
