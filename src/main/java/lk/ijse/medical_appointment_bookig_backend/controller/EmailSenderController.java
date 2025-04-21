package lk.ijse.medical_appointment_bookig_backend.controller;


import jakarta.validation.Valid;

import lk.ijse.medical_appointment_bookig_backend.dto.MailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhanujaya(Dhanu)
 * @TimeStamp 27/03/2025 18:46
 * @ProjectDetails Medical_Appoinment_System
 */
@RestController
@RequestMapping("api/v1/mail")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmailSenderController {


    private JavaMailSender mailSender;

    @PostMapping("save")
    public void mailSender(@Valid @RequestBody MailDTO mailDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mailDto.getSubject());
        message.setTo(mailDto.getEmail());
        message.setFrom("sahandanujaya48@gmail.com");
        message.setText(mailDto.getMessage());
        mailSender.send(message);
    }
}
