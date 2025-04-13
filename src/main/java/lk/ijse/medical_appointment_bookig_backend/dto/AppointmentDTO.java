package lk.ijse.medical_appointment_bookig_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {
    private UUID id;
    private String details;  // Customize fields as per the Appointment entity
    private String date;
}
