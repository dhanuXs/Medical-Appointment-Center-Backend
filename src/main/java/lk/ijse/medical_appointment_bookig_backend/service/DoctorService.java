package lk.ijse.medical_appointment_bookig_backend.service;

import jakarta.validation.Valid;
import lk.ijse.medical_appointment_bookig_backend.dto.DoctorDTO;

public interface DoctorService {
    int saveDoctor(@Valid DoctorDTO doctorDTO);
}
