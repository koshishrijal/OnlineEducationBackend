package com.asky.backend.service.Iservice;

import com.asky.backend.entity.Lesson;
import com.asky.backend.model.LessonModel.LessonDtoForInsert;

import java.util.List;

public interface ILessonService {

    public List<Lesson> findAllLessons();

    public Lesson insertLesson(Lesson lesson);

    public Lesson UpdateLesson(Lesson lesson);
}
