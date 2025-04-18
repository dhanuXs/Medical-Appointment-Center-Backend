package lk.ijse.medical_appointment_bookig_backend.dto;

public class CombinedRequestDTO {
        private AppointmentDTO appointment;
        private PatientDTO patient;
        private UserDTO user;

    public CombinedRequestDTO() {
    }

    public CombinedRequestDTO(AppointmentDTO appointment, PatientDTO patient, UserDTO user) {
        this.appointment = appointment;
        this.patient = patient;
        this.user = user;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
