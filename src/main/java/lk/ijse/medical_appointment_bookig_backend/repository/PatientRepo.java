package lk.ijse.medical_appointment_bookig_backend.repository;

import lk.ijse.medical_appointment_bookig_backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,String> {
    boolean existsByEmail(String email);
    Patient findByEmail(String email);
}
