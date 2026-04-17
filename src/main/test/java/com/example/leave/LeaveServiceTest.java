package com.example.leave;
import com.example.leave.model.LeaveRequest;
import com.example.leave.service.LeaveService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaveServiceTest {
    private final LeaveService leaveService = new LeaveService();

    @Test
    public void testLeaveApproval() {
        LeaveRequest req = new LeaveRequest();
        req.setId(1L);
        leaveService.applyLeave(req);
        LeaveRequest approvedReq = leaveService.approveLeave(1L);
        assertEquals("APPROVED", approvedReq.getStatus());
    }
}
