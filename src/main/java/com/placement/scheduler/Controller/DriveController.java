package com.placement.scheduler.Controller;

import com.placement.scheduler.Model.Drive;
import com.placement.scheduler.Service.CompanyService;
import com.placement.scheduler.Service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.placement.scheduler.Model.Student;
import com.placement.scheduler.Service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DriveController {

    @Autowired
    private DriveService driveService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StudentService studentService;

    // Show schedule drive page
    @GetMapping("/admin/drive/schedule")
    public String showScheduleDrivePage(Model model) {
        model.addAttribute("drive", new Drive());
        model.addAttribute("companies", companyService.getAllCompanies());
        return "drive-schedule";
    }

    // Handle schedule drive form
    @PostMapping("/admin/drive/schedule")
    public String scheduleDrive(@ModelAttribute Drive drive, Model model) {
        try {
            driveService.scheduleDrive(drive);
            model.addAttribute("success", "Drive scheduled successfully!");
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("companies", companyService.getAllCompanies());
        return "drive-schedule";
    }

    // Show all drives
    @GetMapping("/admin/drives")
    public String getAllDrives(Model model) {
        model.addAttribute("drives", driveService.getAllDrives());
        return "drive-list";
    }

    // Show upcoming drives
    @GetMapping("/drives/upcoming")
    public String getUpcomingDrives(Model model) {
        model.addAttribute("drives", driveService.getUpcomingDrives());
        return "drive-list";
    }
    // Show eligible drives for a student
    @GetMapping("/student/drives/eligible/{studentId}")
    public String getEligibleDrives(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        model.addAttribute("drives", driveService.getEligibleDrives(student));
        model.addAttribute("student", student);
        return "drive-eligible";
    }
}