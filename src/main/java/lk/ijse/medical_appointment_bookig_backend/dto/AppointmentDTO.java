package lk.ijse.medical_appointment_bookig_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

public class AppointmentDTO {
    private UUID patient;
    private Date appointmentDate;  // Customize fields as per the Appointment entity
    private Date appointmentTime;
    private String token;
    private String status;
    private String notes;
    private UUID cancellation;
    private UUID user;
    private UUID schedule;
    private UUID payment;


    public AppointmentDTO() {
    }

    public AppointmentDTO(UUID patient, Date appointmentDate, Date appointmentTime, String token, String status, String notes, UUID cancellation, UUID user, UUID schedule, UUID payment) {
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.token = token;
        this.status = status;
        this.notes = notes;
        this.cancellation = cancellation;
        this.user = user;
        this.schedule = schedule;
        this.payment = payment;
    }

    public UUID getPatient() {
        return patient;
    }

    public void setPatient(UUID patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UUID getCancellation() {
        return cancellation;
    }

    public void setCancellation(UUID cancellation) {
        this.cancellation = cancellation;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public UUID getSchedule() {
        return schedule;
    }

    public void setSchedule(UUID schedule) {
        this.schedule = schedule;
    }

    public UUID getPayment() {
        return payment;
    }

    public void setPayment(UUID payment) {
        this.payment = payment;
    }
}
