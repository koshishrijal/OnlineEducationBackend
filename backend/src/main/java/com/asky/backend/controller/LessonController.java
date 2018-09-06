package com.asky.backend.controller;

import com.asky.backend.entity.Lesson;
import com.asky.backend.model.LessonModel.LessonDtoForGet;
import com.asky.backend.model.LessonModel.LessonDtoForInsert;
import com.asky.backend.service.LessonService;
import com.asky.backend.util.PersonalModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value="/api/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value="")
    public ResponseEntity<?> getAllLessons(){
        List<LessonDtoForGet> lessonList=PersonalModelMapper.mapListEntityToListDtos(lessonService.findAllLessons(),LessonDtoForGet.class);
        return ResponseEntity.ok(lessonList);

    }
    @PostMapping(value="/lesson")
    public ResponseEntity<?> insertLesson(@RequestBody LessonDtoForInsert lessonDtoForInsert, Errors errors){
        String errorMessage="";
        if(errors.hasErrors()){
          errorMessage=errors.getAllErrors().stream().map((error)->error.getDefaultMessage()).collect(Collectors.joining(","));
        return ResponseEntity.badRequest().body(errorMessage);
        }
        Lesson lesson=lessonService.insertLesson(modelMapper.map(lessonDtoForInsert,Lesson.class));

        return null;
    }

}
