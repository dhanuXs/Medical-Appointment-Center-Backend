package lk.ijse.medical_appointment_bookig_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceDTO {
    private UUID doctorId;
    private LocalDate attendanceDate;
    private Date inTime;
    private Date outTime;
    private Boolean present;
}
