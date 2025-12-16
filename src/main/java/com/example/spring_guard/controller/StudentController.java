package com.example.spring_guard.controller;

import com.example.spring_guard.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Leyla Aliyeva"),
            new Student(2L, "Ibrahim Alizade"),
            new Student(3L, "Gunel Aliyeva")
    );

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return STUDENTS
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + id + " id doesn't exist"));
    }
}
