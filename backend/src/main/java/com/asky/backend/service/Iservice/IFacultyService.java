package com.asky.backend.service.Iservice;

import com.asky.backend.entity.Faculty;

import java.util.List;

public interface IFacultyService {

    public List<Faculty> getAllfaculty();

    public Faculty getFacultyById(int facultyId);

    public Faculty insertFaculty(Faculty faculty);

    public void deletFaculty(Faculty faculty);

    public Faculty updateFaculty(Faculty faculty);

    public boolean isFacultyExists(int facultyId);



}
