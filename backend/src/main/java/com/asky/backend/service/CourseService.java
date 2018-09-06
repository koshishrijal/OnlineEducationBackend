package com.asky.backend.service;

import com.asky.backend.entity.Course;
import com.asky.backend.repository.CourseRepository;
import com.asky.backend.service.Iservice.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseService")
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseByCourseId(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void deleteCourseByCourseId(int id) {

    }

    @Override
    public Course insertCourse(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }

    @Override
    public boolean isCourseExists(int courseId) {
        return false;
    }
}
