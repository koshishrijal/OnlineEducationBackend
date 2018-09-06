package com.asky.backend.service;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.repository.UserHasCourseRepository;
import com.asky.backend.service.Iservice.IUserHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("userHasCourseService")
public class UserHasCourseService implements IUserHasCourseService {
    @Autowired
    private UserHasCourseRepository userHasCourseRepository;
    @Override
    public List<Course> getListofCourseEnrolledByUserId(int userId) {
        List<Course> courseList=new ArrayList<>();
        userHasCourseRepository.findAll().forEach((UserHasCourse userHasCourse)->{
            if(userHasCourse.getUser().getUserId()==userId){
                courseList.add(userHasCourse.getCourse());
            }
        });
        return courseList;
    }

    @Override
    public List<User> getListOfUserForCourseByCourseId(int courseId)
    {
        return null;
    }

    @Override
    public List<UserHasCourse> getUserHasCourseListByUserId(int userId) {
       return     userHasCourseRepository.findAll().stream().filter(userHasCourse -> userHasCourse.getUser().getUserId()==userId).collect(Collectors.toList());
      //  return userHasCourseRepository.getUserHasCourseListByUserId(userId);
    }


}