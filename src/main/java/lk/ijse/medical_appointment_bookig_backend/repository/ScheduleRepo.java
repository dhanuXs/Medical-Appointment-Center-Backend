package lk.ijse.medical_appointment_bookig_backend.repository;

import lk.ijse.medical_appointment_bookig_backend.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {
    Schedule findById(UUID uuid);
}
