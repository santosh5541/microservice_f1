package com.microservices.student.microservices.student.service.impl;

import com.microservices.student.microservices.student.dto.SchoolDto;
import com.microservices.student.microservices.student.dto.StudentResponseDto;
import com.microservices.student.microservices.student.model.Student;
import com.microservices.student.microservices.student.repo.StudentRepository;
import com.microservices.student.microservices.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentResponseDto fetchStudentById(int id) {
        return studentRepository.findById(id)
                .map(student -> {
                    SchoolDto school = restTemplate.getForObject("http://School-Service/school/" + student.getSchoolId(), SchoolDto.class);
                    return new StudentResponseDto(student.getId(), student.getName(), student.getAge(), student.getGender(), school);
                })
                .orElse(null);
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        if (studentRepository.findById(student.getId()).isPresent()) {
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
