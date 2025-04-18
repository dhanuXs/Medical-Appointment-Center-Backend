package lk.ijse.medical_appointment_bookig_backend.repository;

import lk.ijse.medical_appointment_bookig_backend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,String> {
}
