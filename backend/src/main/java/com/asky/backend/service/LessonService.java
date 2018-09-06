package com.asky.backend.service;

import com.asky.backend.entity.Lesson;
import com.asky.backend.model.LessonModel.LessonDtoForInsert;
import com.asky.backend.repository.LessonRepository;
import com.asky.backend.service.Iservice.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lessonService")
public class LessonService implements ILessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson insertLesson(Lesson lesson) {
       return lessonRepository.saveAndFlush(lesson);
    }

    @Override
    public Lesson UpdateLesson(Lesson lesson) {
      return  lessonRepository.saveAndFlush(lesson);
    }
}
