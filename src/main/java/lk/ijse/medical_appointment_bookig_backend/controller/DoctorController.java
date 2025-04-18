package lk.ijse.medical_appointment_bookig_backend.controller;

import jakarta.validation.Valid;
import lk.ijse.medical_appointment_bookig_backend.dto.DoctorDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.ResponseDTO;
import lk.ijse.medical_appointment_bookig_backend.service.DoctorService;
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
@RequestMapping("api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDTO> saveDoctor(@RequestBody @Valid
                                                  DoctorDTO doctorDTO) {
        try{
            int statusCode = doctorService.saveDoctor(doctorDTO);
            switch (statusCode) {
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK,"Saved Successfully!",doctorDTO));
                }
                case VarList.Not_Found -> {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ResponseDTO(VarList.Not_Found,"Not Found",null));
                }
                case VarList.Internal_Server_Error -> {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(new ResponseDTO(VarList.Internal_Server_Error,"Internal Server Error",null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ResponseDTO(statusCode,"Bad Request",null));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error,e.getMessage(),null));
        }
    }
}
