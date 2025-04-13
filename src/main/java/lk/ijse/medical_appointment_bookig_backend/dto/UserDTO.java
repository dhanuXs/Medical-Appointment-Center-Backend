package lk.ijse.medical_appointment_bookig_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String email;
    private String name;
    private String password;
    private String contactNumber;
    private String imgUrl;
    private String role;
}
