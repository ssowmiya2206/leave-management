package com.example.lms.controller;

import com.example.lms.model.LeaveRequest;
import com.example.lms.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * Endpoint to submit a new leave request.
     * POST http://localhost:8080/api/leaves/apply
     */
    @PostMapping("/apply")
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest leaveRequest) {
        LeaveRequest savedRequest = leaveService.applyForLeave(leaveRequest);
        return ResponseEntity.ok(savedRequest);
    }

    /**
     * Endpoint for managers to approve or reject a leave request.
     * PUT http://localhost:8080/api/leaves/{id}/status?status=APPROVED
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateLeaveStatus(
            @PathVariable Long id, 
            @RequestParam String status) {
        String response = leaveService.processLeave(id, status);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint to view history of all leave requests.
     * GET http://localhost:8080/api/leaves/history
     */
    @GetMapping("/history")
    public ResponseEntity<List<LeaveRequest>> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }
}
