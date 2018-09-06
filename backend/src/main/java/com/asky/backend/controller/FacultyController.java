package com.asky.backend.controller;

import com.asky.backend.entity.Faculty;
import com.asky.backend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public ResponseEntity<?> getAllFaculties(){

      List<Faculty> facultyList =facultyService.getAllfaculty();
        if(facultyList==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occured while processing");
        }

        return ResponseEntity.ok(facultyList);
    }
}
