package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDetails addStudent(@RequestBody StudentDetails student) {
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
    public StudentDetails updateStudent(@PathVariable int id, @RequestBody StudentDetails student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean deleted = service.deleteStudent(id);
        return deleted ? "Student deleted successfully" : "Student not found";
    }
}