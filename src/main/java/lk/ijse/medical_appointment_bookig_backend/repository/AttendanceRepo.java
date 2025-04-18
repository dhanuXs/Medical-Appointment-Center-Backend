package lk.ijse.medical_appointment_bookig_backend.repository;

import jakarta.transaction.Transactional;
import lk.ijse.medical_appointment_bookig_backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AttendanceRepo extends JpaRepository<Attendance, String> {
    boolean existsById(UUID doctorID);
    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "INSERT INTO Attendances (id,doctor_id,attendance_date,in_time,out_time,present) VALUES (:id,:doctor,:attendanceDate,:inTime,:outTime,:present)")
    int saveAttendance(@Param("id")UUID uuid, @Param("doctor")UUID id, @Param("attendanceDate") LocalDate date, @Param("inTime")Date in_time,@Param("outTime")Date out_time,@Param("present")boolean present);
}
