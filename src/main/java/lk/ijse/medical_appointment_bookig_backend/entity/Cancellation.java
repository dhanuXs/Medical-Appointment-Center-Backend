package lk.ijse.medical_appointment_bookig_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Cancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private String cancellationMessage;

    @OneToMany(mappedBy = "cancellation",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public Cancellation() {
    }

    public Cancellation(UUID id, String reason, Date date, String cancellationMessage, List<Appointment> appointments) {
        this.id = id;
        this.reason = reason;
        this.date = date;
        this.cancellationMessage = cancellationMessage;
        this.appointments = appointments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCancellationMessage() {
        return cancellationMessage;
    }

    public void setCancellationMessage(String cancellationMessage) {
        this.cancellationMessage = cancellationMessage;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
