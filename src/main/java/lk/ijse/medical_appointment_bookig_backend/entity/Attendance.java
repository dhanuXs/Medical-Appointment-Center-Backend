package lk.ijse.medical_appointment_bookig_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDate attendanceDate; // Date of attendance

    @Column(nullable = false ,name = "in_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intime; // Check-in time

    @Column(name = "out_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outtime; // Check-out time

    @Column(nullable = false)
    private boolean present; // Whether the doctor was present or not
}
