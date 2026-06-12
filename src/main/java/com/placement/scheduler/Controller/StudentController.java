package com.placement.scheduler.Controller;

import com.placement.scheduler.Model.Student;
import com.placement.scheduler.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show registration page
    @GetMapping("/student/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("student", new Student());
        return "student-register";
    }

    // Handle registration form submission
    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        try {
            studentService.registerStudent(student);
            model.addAttribute("success", "Registration successful!");
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "student-register";
    }

    // Show all students (admin view)
    @GetMapping("/admin/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }
}