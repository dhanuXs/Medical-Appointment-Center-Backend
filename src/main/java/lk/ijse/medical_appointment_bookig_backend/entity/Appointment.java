package lk.ijse.medical_appointment_bookig_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false,name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate; // Date of the appointment

    @Column(nullable = false,name = "appointment_time")
    @Temporal(TemporalType.TIME)
    private Date appointmentTime; // Time of the appointment

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String status; // Pending, Approved, Completed, Cancelled

    @Column
    private String notes; // Additional notes regarding the appointment

    @ManyToOne
    @JoinColumn(name = "cancellation_id")
    private Cancellation cancellation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
