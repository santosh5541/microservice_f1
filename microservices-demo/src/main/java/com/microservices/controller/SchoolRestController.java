package com.microservices.controller;

import com.microservices.model.School;
import com.microservices.service.SchoolService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/school")
public class SchoolRestController {
    private final SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable(name = "id") int id) {
        return schoolService.getSchoolById(id);
    }
}
