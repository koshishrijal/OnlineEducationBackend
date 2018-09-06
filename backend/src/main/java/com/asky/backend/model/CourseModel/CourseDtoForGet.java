package com.asky.backend.model.CourseModel;

import com.asky.backend.entity.Lesson;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.model.LessonModel.LessonDtoForGet;

import java.util.List;

public class CourseDtoForGet{
    private int courseId;
    private String courseName;
    private String description;
    private boolean status;


    private LessonDtoForGet lesson;




    public LessonDtoForGet getLesson() {
        return lesson;
    }

    public void setLesson(LessonDtoForGet lesson) {
        this.lesson = lesson;
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
