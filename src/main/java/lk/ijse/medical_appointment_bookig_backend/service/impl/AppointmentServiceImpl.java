package lk.ijse.medical_appointment_bookig_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.medical_appointment_bookig_backend.dto.AppointmentDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.CombinedRequestDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.PatientDTO;
import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;
import lk.ijse.medical_appointment_bookig_backend.entity.Appointment;
import lk.ijse.medical_appointment_bookig_backend.entity.Patient;
import lk.ijse.medical_appointment_bookig_backend.entity.Schedule;
import lk.ijse.medical_appointment_bookig_backend.entity.User;
import lk.ijse.medical_appointment_bookig_backend.repository.AppointmentRepo;
import lk.ijse.medical_appointment_bookig_backend.repository.PatientRepo;
import lk.ijse.medical_appointment_bookig_backend.repository.ScheduleRepo;
import lk.ijse.medical_appointment_bookig_backend.repository.UserRepo;
import lk.ijse.medical_appointment_bookig_backend.service.AppointmentService;
import lk.ijse.medical_appointment_bookig_backend.util.VarList;
import org.aspectj.weaver.ast.Var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public int saveAppointment(CombinedRequestDTO combinedRequestDTO) {
        // 1. Save patient if not exists
        if (!patientRepo.existsByEmail(combinedRequestDTO.getPatient().getEmail())) {
            Patient newPatient = modelMapper.map(combinedRequestDTO.getPatient(), Patient.class);
            patientRepo.save(newPatient);
        }

        // 2. Get the patient by email
        Patient patient = patientRepo.findByEmail(combinedRequestDTO.getPatient().getEmail());

        // 3. Get the user by email
        User user = userRepo.findByEmail(combinedRequestDTO.getUser().getEmail());

        if (patient == null || user == null) {
            return VarList.Not_Found;
        }

        // 4. Map AppointmentDTO to Appointment (without setting user/patient yet)
        Appointment appointment = modelMapper.map(combinedRequestDTO.getAppointment(), Appointment.class);

        // 5. Set user and patient manually (required for Hibernate)
        appointment.setPatient(patient);
        appointment.setUser(user);

        // 7. Save the appointment
        Appointment savedAppointment = appointmentRepo.save(appointment);

        return savedAppointment != null ? VarList.Created : VarList.Bad_Gateway;
    }

}
