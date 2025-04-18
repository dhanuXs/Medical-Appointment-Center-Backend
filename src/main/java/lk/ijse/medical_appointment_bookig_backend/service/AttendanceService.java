package lk.ijse.medical_appointment_bookig_backend.service;

import lk.ijse.medical_appointment_bookig_backend.dto.AttendanceDTO;

public interface AttendanceService {
    int saveAttendance(AttendanceDTO attendanceDTO);
}
