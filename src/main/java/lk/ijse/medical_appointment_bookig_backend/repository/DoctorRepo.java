package lk.ijse.medical_appointment_bookig_backend.repository;

import lk.ijse.medical_appointment_bookig_backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, String> {
    boolean existsByEmail(String email);
}
