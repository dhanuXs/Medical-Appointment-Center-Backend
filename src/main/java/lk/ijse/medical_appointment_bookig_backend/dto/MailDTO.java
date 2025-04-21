package lk.ijse.medical_appointment_bookig_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dhanujaya(Dhanu)
 * @TimeStamp 27/03/2025 19:14
 * @ProjectDetails Medical_Appoinment_System
 */

public class MailDTO {
    private String email;
    private String subject;
    private String message;

    public MailDTO() {
    }

    public MailDTO(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
