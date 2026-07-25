package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public StudentDetails createStudent(StudentDetails student) {
        return repository.save(student);
    }

    public List<StudentDetails> getAllStudents() {
        return repository.findAll();
    }

    public StudentDetails getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }
    public StudentDetails updateStudent(int id, StudentDetails updatedStudent) {
        StudentDetails existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        return repository.save(existing);
    }

    public boolean deleteStudent(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}