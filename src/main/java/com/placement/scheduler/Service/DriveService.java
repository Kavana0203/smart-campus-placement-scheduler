package com.placement.scheduler.Service;

import com.placement.scheduler.Model.Drive;
import com.placement.scheduler.Model.Company;
import com.placement.scheduler.Repository.DriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
}