package com.asky.backend.controller;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.model.CourseModel.CourseDtoForGet;
import com.asky.backend.model.CourseModel.CourseDtoForInsert;
import com.asky.backend.service.CourseService;
import com.asky.backend.util.PersonalModelMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping(value="/api/courses")
public class CourseController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CourseService courseService;


    @GetMapping
    public ResponseEntity<?> getAllCourse(){
         List<Course> courseList=courseService.getAllCourses();
       // ((List<Course>) courseList).add(new Course(1,"jpt","sj",false));
        if(courseList==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

      List<CourseDtoForGet> courseListDtoForGet= PersonalModelMapper.mapListEntityToListDtos(courseList,CourseDtoForGet.class);
        return ResponseEntity.ok().body(courseListDtoForGet);

    }
    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable("courseId") int courseId){
        Optional<Course> course=courseService.getCourseByCourseId(courseId);
        if(!course.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(course);
    }
    @PostMapping("/course")
    public ResponseEntity insertCourse(@Valid @RequestBody CourseDtoForInsert course,Errors errors){
        String errorMessage="";

        if(errors.hasErrors()){
            errorMessage=collectAndFlattenAllErrorMessages(errors);
            return ResponseEntity.badRequest().body(errorMessage);
        }
        Course courseInserted=courseService.insertCourse(modelMapper.map(course,Course.class));
        if(courseInserted==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        URI uriOfCreatedCourse=URI.create("/api/courses/course/"+courseInserted.getCourseId());
        return ResponseEntity.created(uriOfCreatedCourse).build();

    }

    private String collectAndFlattenAllErrorMessages(Errors errors){

        return errors.getMessages().stream().map(error->error.getMessage()).collect(Collectors.joining(","));

    }


}
