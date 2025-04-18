package lk.ijse.medical_appointment_bookig_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
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
    private Date inTime; // Check-in time

    @Column(name = "out_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date outTime; // Check-out time

    @Column(nullable = false)
    private boolean present; // Whether the doctor was present or not

    public Attendance() {
    }

    public Attendance(UUID id, Doctor doctor, LocalDate attendanceDate, Date inTime, Date outTime, boolean present) {
        this.id = id;
        this.doctor = doctor;
        this.attendanceDate = attendanceDate;
        this.inTime = inTime;
        this.outTime = outTime;
        this.present = present;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
