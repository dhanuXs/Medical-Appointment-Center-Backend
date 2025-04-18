package lk.ijse.medical_appointment_bookig_backend.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


public class UserDTO {
    @Email
    private String email;
    private String name;
    private String password;
    private String contactNumber;
    private String imgUrl;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String email, String name, String password, String contactNumber, String imgUrl, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.imgUrl = imgUrl;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
