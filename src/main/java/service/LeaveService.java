package com.example.leave.service;
import com.example.leave.model.LeaveRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LeaveService {
    private Map<Long, LeaveRequest> leaveDatabase = new HashMap<>();
    private int leaveBalance = 20; // Default balance

    public LeaveRequest applyLeave(LeaveRequest request) {
        request.setStatus("PENDING");
        leaveDatabase.put(request.getId(), request);
        return request;
    }

    public LeaveRequest approveLeave(Long leaveId) {
        LeaveRequest request = leaveDatabase.get(leaveId);
        if (request != null && "PENDING".equals(request.getStatus())) {
            // Simple logic: 1 day check
            request.setStatus("APPROVED");
            leaveBalance--;
        }
        return request;
    }
}
