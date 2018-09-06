package com.asky.backend.service.Iservice;

import com.asky.backend.entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public List<Course> getAllCourses();
    public Optional<Course> getCourseByCourseId(int id);
    public void deleteCourseByCourseId(int id);
    public Course insertCourse(Course course);
    public Course updateCourse(Course course);
    public boolean isCourseExists(int courseId);
}
