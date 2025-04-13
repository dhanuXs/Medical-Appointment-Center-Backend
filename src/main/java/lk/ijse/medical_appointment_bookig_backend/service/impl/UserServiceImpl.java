package lk.ijse.medical_appointment_bookig_backend.service.impl;

import lk.ijse.medical_appointment_bookig_backend.advicer.GlobalExceptionHandler;
import lk.ijse.medical_appointment_bookig_backend.dto.UserDTO;
import lk.ijse.medical_appointment_bookig_backend.entity.User;
import lk.ijse.medical_appointment_bookig_backend.repository.UserRepo;
import lk.ijse.medical_appointment_bookig_backend.service.UserService;
import lk.ijse.medical_appointment_bookig_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public UserDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            User user=userRepository.findByEmail(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public int deleteUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
           userRepository.delete(modelMapper.map(userDTO, User.class));
           return VarList.OK;
        }
        return VarList.Not_Found;
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            User user = userRepository.findByEmail(userDTO.getEmail());
            if (user != null) {
                user.setEmail(userDTO.getEmail());
                user.setPassword(userDTO.getPassword());
                user.setName(userDTO.getName());
                user.setRole(userDTO.getRole());
                user.setImgUrl(userDTO.getImgUrl());
                userRepository.save(user);
                return VarList.OK;
            } else {
                return VarList.Not_Found;
            }
        }
        return VarList.Not_Found;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return modelMapper.map(users,
                new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }
    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }



}
