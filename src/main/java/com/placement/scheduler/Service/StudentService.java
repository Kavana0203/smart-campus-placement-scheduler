package com.placement.scheduler.Service;

import com.placement.scheduler.Model.Student;
import com.placement.scheduler.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Register a new student
    public Student registerStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Get student by email
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // Update student
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    // Total students count
    public long getTotalStudents() {
        return studentRepository.count();
    }

    // Total placed students
    public long getTotalPlacedStudents() {
        return studentRepository.findAll()
                .stream()
                .filter(Student::isPlaced)
                .count();
    }

    // Branch wise student count
    public java.util.Map<String, Long> getStudentsByBranch() {
        return studentRepository.findAll()
                .stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        Student::getBranch,
                        java.util.stream.Collectors.counting()
                ));
    }
}