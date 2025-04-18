package lk.ijse.medical_appointment_bookig_backend.service;

import lk.ijse.medical_appointment_bookig_backend.dto.AppointmentDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.CombinedRequestDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.PatientDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;

public interface AppointmentService {
    int saveAppointment(CombinedRequestDTO combinedRequestDTO);
}
