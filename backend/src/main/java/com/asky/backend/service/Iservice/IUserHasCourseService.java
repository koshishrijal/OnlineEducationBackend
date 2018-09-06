package com.asky.backend.service.Iservice;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.entity.UserHasCourse;

import java.util.List;

public interface IUserHasCourseService {

    public List<Course> getListofCourseEnrolledByUserId(int userId);

    public List<User> getListOfUserForCourseByCourseId(int courseId);

    public List<UserHasCourse> getUserHasCourseListByUserId(int userId);

    public default void test(){
        String name="koshishs";
    }
}
