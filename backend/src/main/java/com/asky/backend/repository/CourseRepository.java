package com.asky.backend.repository;

import com.asky.backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Override
    Optional<Course> findById(Integer id);
}
