package com.asky.backend.repository;

import com.asky.backend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lessonRepository")
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
