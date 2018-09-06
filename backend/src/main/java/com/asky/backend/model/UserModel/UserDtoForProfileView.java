package com.asky.backend.model.UserModel;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.model.CourseModel.CourseDtoForGet;
import com.asky.backend.service.Iservice.IUserHasCourseService;
import com.asky.backend.service.UserHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoForProfileView {


//contained in user entity
    private int userId;
//contained in userEntity
    private String username;

    //contained in user entity
    private String[] enrolledCourseNames;


    private int totalCourseCount;

    private int courseCompleted;

    private String[] completedCourseName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getEnrolledCourseNames() {
        return enrolledCourseNames;
    }

    public int getTotalCourseCount() {
        return totalCourseCount;
    }

    public int getCourseCompleted() {
        return courseCompleted;
    }

    public String[] getCompletedCourseName() {
        return completedCourseName;
    }

    public void setAdditionalFields(UserHasCourseService userHasCourseService) {

       // this.enrolledCourseNames=courseDtoForGetList.stream().map(course->course.getCourseName()).toArray(i->new String[i]);
        this.enrolledCourseNames= userHasCourseService.getListofCourseEnrolledByUserId(this.userId)
                                .stream()
                                 .map(userHasCourse->userHasCourse.getCourseName())
                                 .toArray(i->new String[i]);
        this.completedCourseName=
                userHasCourseService.getUserHasCourseListByUserId(this.userId)
                .stream()
                        .filter((userHasCourse)->userHasCourse.isCourseCompleted()==true)
                .map(userHasCourse->userHasCourse.getCourse().getCourseName())
                .toArray(i->new String[i]);

        this.totalCourseCount=this.enrolledCourseNames.length;
        this.courseCompleted=this.completedCourseName.length;


    }




}

