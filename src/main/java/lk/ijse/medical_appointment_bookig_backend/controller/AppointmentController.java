package lk.ijse.medical_appointment_bookig_backend.controller;

import lk.ijse.medical_appointment_bookig_backend.dto.*;
import lk.ijse.medical_appointment_bookig_backend.service.AppointmentService;
import lk.ijse.medical_appointment_bookig_backend.util.VarList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDTO> saveAppointment(@RequestBody CombinedRequestDTO combinedRequestDTO){
        try{
            int statusCode = appointmentService.saveAppointment(combinedRequestDTO);
            switch (statusCode){
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK,"appointment placed successfully",combinedRequestDTO));
                }
                case VarList.Bad_Gateway -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway,"appointment placed unsuccessfully",null));
                }
                case VarList.Not_Found -> {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ResponseDTO(VarList.Not_Found,"not found",null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ResponseDTO(VarList.Bad_Request,"error",null));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error,e.getMessage(),null));
        }
    }
}
