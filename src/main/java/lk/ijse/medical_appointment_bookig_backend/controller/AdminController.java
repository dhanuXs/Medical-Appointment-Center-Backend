package lk.ijse.medical_appointment_bookig_backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ijse.medical_appointment_bookig_backend.dto.ResponseDTO;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test1")
    public ResponseDTO test1() {
        return new ResponseDTO(200, "Admin access only: Test successful", null);
    }
}
