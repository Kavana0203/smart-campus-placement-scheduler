package com.placement.scheduler.Controller;

import com.placement.scheduler.Service.CompanyService;
import com.placement.scheduler.Service.DriveService;
import com.placement.scheduler.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DriveService driveService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model) {

        // Student stats
        model.addAttribute("totalStudents",
                studentService.getTotalStudents());
        model.addAttribute("placedStudents",
                studentService.getTotalPlacedStudents());
        model.addAttribute("unplacedStudents",
                studentService.getTotalStudents() -
                        studentService.getTotalPlacedStudents());
        model.addAttribute("branchStats",
                studentService.getStudentsByBranch());

        // Drive stats
        model.addAttribute("totalDrives",
                driveService.getTotalDrives());
        model.addAttribute("upcomingDrives",
                driveService.getUpcomingDrivesCount());
        model.addAttribute("completedDrives",
                driveService.getCompletedDrivesCount());

        // Company stats
        model.addAttribute("totalCompanies",
                companyService.getAllCompanies().size());

        return "dashboard";
    }
}