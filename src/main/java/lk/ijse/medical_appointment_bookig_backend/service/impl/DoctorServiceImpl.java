package lk.ijse.medical_appointment_bookig_backend.service.impl;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lk.ijse.medical_appointment_bookig_backend.dto.AttendanceDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.DoctorDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;
import lk.ijse.medical_appointment_bookig_backend.entity.Doctor;
import lk.ijse.medical_appointment_bookig_backend.repository.DoctorRepo;
import lk.ijse.medical_appointment_bookig_backend.service.AttendanceService;
import lk.ijse.medical_appointment_bookig_backend.service.DoctorService;
import lk.ijse.medical_appointment_bookig_backend.service.UserService;
import lk.ijse.medical_appointment_bookig_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public int saveDoctor(DoctorDTO doctorDTO) {
        if (!doctorRepo.existsByEmail(doctorDTO.getEmail())){
            Doctor save = doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
            if (save.getId() != null) {
                userService.saveUser(new UserDTO(doctorDTO.getEmail(),doctorDTO.getName(), doctorDTO.getName()+"1234",doctorDTO.getContactNumber(),doctorDTO.getImgUrl(),"DOCTOR"));
                attendanceService.saveAttendance(new AttendanceDTO(save.getId(), LocalDate.now(),null,null,false));
                return VarList.OK;
            } else {
                return VarList.Internal_Server_Error;
            }
        }
        return VarList.Bad_Request;
    }
}
