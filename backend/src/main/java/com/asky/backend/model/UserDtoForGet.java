package com.asky.backend.model;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.model.CourseModel.CourseDtoForGet;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDtoForGet {

    @NotNull(message = "name must not be null")
    private String username;
    @NotNull(message ="email mst not be null")
    private String email;
    @NotNull(message="password is required")
    private String password;

    private List<CourseDtoForGet> courseList;

    private int userId;

    public List<CourseDtoForGet> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDtoForGet> courseList) {
        this.courseList = courseList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
