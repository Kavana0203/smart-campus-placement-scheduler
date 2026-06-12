package com.placement.scheduler.Service;

import com.placement.scheduler.Model.Drive;
import com.placement.scheduler.Model.Company;
import com.placement.scheduler.Repository.DriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.placement.scheduler.Model.Student;
import java.util.ArrayList;

@Service
public class DriveService {

    @Autowired
    private DriveRepository driveRepository;

    public Drive scheduleDrive(Drive drive) {
        // Conflict detection — same company same date!
        if (driveRepository.existsByCompanyAndDriveDate(
                drive.getCompany(), drive.getDriveDate())) {
            throw new RuntimeException(
                    "Drive already scheduled for this company on this date!");
        }
        return driveRepository.save(drive);
    }

    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    public List<Drive> getUpcomingDrives() {
        return driveRepository.findByStatus("UPCOMING");
    }

    public Optional<Drive> getDriveById(Long id) {
        return driveRepository.findById(id);
    }

    public List<Drive> getDrivesByCompany(Company company) {
        return driveRepository.findByCompany(company);
    }

    public Drive updateDriveStatus(Long id, String status) {
        Drive drive = driveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drive not found!"));
        drive.setStatus(status);
        return driveRepository.save(drive);
    }

    public void deleteDrive(Long id) {
        driveRepository.deleteById(id);
    }
    // Get eligible drives for a student
    public List<Drive> getEligibleDrives(Student student) {
        List<Drive> allDrives = driveRepository.findByStatus("UPCOMING");
        List<Drive> eligibleDrives = new ArrayList<>();

        for (Drive drive : allDrives) {
            Company company = drive.getCompany();

            // Check CGPA
            boolean cgpaOk = student.getCgpa() >= company.getMinCgpa();

            // Check backlogs
            boolean backlogsOk = student.getBacklogs() <= company.getMaxBacklogs();

            // Check branch
            boolean branchOk = company.getEligibleBranches()
                    .contains(student.getBranch());

            if (cgpaOk && backlogsOk && branchOk) {
                eligibleDrives.add(drive);
            }
        }
        return eligibleDrives;
    }
}