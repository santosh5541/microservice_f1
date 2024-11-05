package com.microservices.service;

import com.microservices.model.School;

import java.util.List;

public interface SchoolService {
    public School addSchool(School school);
    public List<School> getAllSchools();
    public School getSchoolById(int id);
}
