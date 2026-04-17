package com.example.lms.repository;

import com.example.lms.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {
    
    // Custom query to find all leave requests for a specific employee
    List<LeaveRequest> findByEmployeeId(Long employeeId);

    // Custom query to find leaves by status (e.g., "PENDING")
    List<LeaveRequest> findByStatus(String status);
}
