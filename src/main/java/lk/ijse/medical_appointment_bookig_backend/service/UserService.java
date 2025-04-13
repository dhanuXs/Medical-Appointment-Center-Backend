package lk.ijse.medical_appointment_bookig_backend.service;

import jakarta.validation.Valid;
import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    int deleteUser(UserDTO userDTO);

    int updateUser(UserDTO userDTO);

    List<UserDTO> getUsers();
}
