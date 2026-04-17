package com.example.leave.service;

import com.example.leave.model.LeaveRequest;
import com.example.leave.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveRequest applyForLeave(LeaveRequest request) {
        request.setStatus("PENDING");
        return leaveRepository.save(request);
    }

    public String processLeave(Long id, String status) {
        LeaveRequest request = leaveRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus(status);
            leaveRepository.save(request);
            return "Leave " + status;
        }
        return "Request Not Found";
    }

    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }
}
