package com.placement.scheduler.Repository;

import com.placement.scheduler.Model.Drive;
import com.placement.scheduler.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Long> {
    List<Drive> findByStatus(String status);
    List<Drive> findByCompany(Company company);
    boolean existsByCompanyAndDriveDate(Company company, LocalDate driveDate);
}