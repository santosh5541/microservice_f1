package com.microservices.student.microservices.student.service;

import com.microservices.student.microservices.student.dto.StudentResponseDto;
import com.microservices.student.microservices.student.model.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);

    public StudentResponseDto fetchStudentById(int id);

    public List<Student> fetchStudents();

    public Student updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> searchStudentsByName(String name);
}
