package com.asky.backend.service;

import com.asky.backend.entity.Faculty;
import com.asky.backend.service.Iservice.IFacultyService;
import com.asky.backend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("facultyService")
public class FacultyService implements IFacultyService {

    @Autowired
    private FacultyRepository facultyRespository;


    @Override
    public List<Faculty> getAllfaculty() {

        return facultyRespository.findAll();
    }

    @Override
    public Faculty getFacultyById(int facultyId) {
        return null;
    }

    @Override
    public Faculty insertFaculty(Faculty faculty) {
        return null;
    }

    @Override
    public void deletFaculty(Faculty faculty) {

    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return null;
    }

    @Override
    public boolean isFacultyExists(int facultyId) {
        return false;
    }
}
