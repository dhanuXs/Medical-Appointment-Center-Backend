package lk.ijse.medical_appointment_bookig_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedicalAppointmentBookigBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalAppointmentBookigBackendApplication.class, args);
    }
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
