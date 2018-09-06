package com.asky.backend.model.LessonModel;

import javax.validation.constraints.NotNull;

public class LessonDtoForInsert {
    @NotNull(message = "lesson Name should be required")
    private String lessonName;
    @NotNull(message = "lessondescription should be required")
    private String lessonDescription;
    @NotNull(message = "lessonNumber should be required")
    private int lessonNumber;
    //courseId is the foreign key for lesson object
    @NotNull(message="foreign  key courseid should be required for inserting a lesson")
    private int courseId;

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

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
