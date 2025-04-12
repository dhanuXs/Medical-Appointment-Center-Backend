package lk.ijse.medical_appointment_bookig_backend.service;

import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    int deleteUser(String email);
}
