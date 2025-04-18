package lk.ijse.medical_appointment_bookig_backend.dto;

public class PatientDTO {
    private String name;
    private String contactNumber;
    private String email;
    private String gender;
    private String address;

    public PatientDTO() {
    }

    public PatientDTO(String name, String contactNumber, String email, String gender, String address) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
