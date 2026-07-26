package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDetails addStudent(@Valid @RequestBody StudentDetails student) {
        return service.createStudent(student);
    }

    @GetMapping
    public List<StudentDetails> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDetails getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDetails updateStudent(@PathVariable int id, @Valid @RequestBody StudentDetails student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}