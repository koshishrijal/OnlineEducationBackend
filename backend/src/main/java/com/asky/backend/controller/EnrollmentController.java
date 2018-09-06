package com.asky.backend.controller;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.model.EnrollmentModel.EnrollmentDtoForInsert;
import com.asky.backend.service.CourseService;
import com.asky.backend.service.UserService;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="api/enrollments")
public class EnrollmentController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;


    @PostMapping("/enrollment")
    public ResponseEntity<?> enroll(@Valid @RequestBody EnrollmentDtoForInsert enrollmentDtoForInsert,Errors errors){
    String errorMessage="";
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errorMessage);
        }
        User u=userService.getUserByUserId(enrollmentDtoForInsert.getUserId());
        Course c=courseService.getCourseByCourseId(enrollmentDtoForInsert.getCourseId()).get();
        UserHasCourse uhs=new UserHasCourse();
        uhs.setCourse(c);
        uhs.setUser(u);
        u.getUserHasCourseList().add(uhs);
        userService.updateUser(u);

     return ResponseEntity.noContent().build();
    }



}
