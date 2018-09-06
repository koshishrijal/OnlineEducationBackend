package com.asky.backend.service;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.repository.CourseRepository;
import com.asky.backend.repository.UserRepository;
import com.asky.backend.service.Iservice.IEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("enrollService")
public class EnrollService implements IEnrollService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseReposiotory;
    @Override
    public User enrollUser(int userId, int courseId) {
        User user=userRepository.findOneUserByUserId(userId);
        Course course=courseReposiotory.findById(courseId).get();
        if(user== null){
            throw new RuntimeException("userId from request dont contain any user");
        }
        if(course==null){
            throw new RuntimeException("courseId from request dont contain any couorse");
        }
        UserHasCourse userHasCourse=new UserHasCourse();
        userHasCourse.setUser(user);
        userHasCourse.setCourse(course);
        user.getUserHasCourseList().add(userHasCourse);
        userRepository.saveAndFlush(user);

        return user;
    }
}
