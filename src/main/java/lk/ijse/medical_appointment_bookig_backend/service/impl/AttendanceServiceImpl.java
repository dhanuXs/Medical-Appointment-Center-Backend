package lk.ijse.medical_appointment_bookig_backend.service.impl;

import lk.ijse.medical_appointment_bookig_backend.dto.AppointmentDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.AttendanceDTO;
import lk.ijse.medical_appointment_bookig_backend.entity.Appointment;
import lk.ijse.medical_appointment_bookig_backend.entity.Attendance;
import lk.ijse.medical_appointment_bookig_backend.repository.AttendanceRepo;
import lk.ijse.medical_appointment_bookig_backend.service.AttendanceService;
import lk.ijse.medical_appointment_bookig_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveAttendance(AttendanceDTO attendanceDTO) {
        if (!attendanceRepo.existsById(attendanceDTO.getDoctorId())){
            int statusCode = attendanceRepo.saveAttendance(UUID.randomUUID(),attendanceDTO.getDoctorId(), attendanceDTO.getAttendanceDate(), Timestamp.valueOf(LocalDate.now().atStartOfDay()),null, false);
            if (statusCode == 200) {
                return VarList.OK;
            } else {
                return VarList.Internal_Server_Error;
            }
        }
        return VarList.Not_Found;
    }
}
