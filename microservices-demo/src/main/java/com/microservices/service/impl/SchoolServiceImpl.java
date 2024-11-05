package com.microservices.service.impl;

import com.microservices.model.School;
import com.microservices.repo.SchoolRepository;
import com.microservices.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(int id) {
        return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
    }
}
