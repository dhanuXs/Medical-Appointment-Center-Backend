package lk.ijse.medical_appointment_bookig_backend.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDTO {
    private String name;
    private String specialization;
    private String contactNumber;
    @Email
    private String email;
    private String imgUrl;
}
