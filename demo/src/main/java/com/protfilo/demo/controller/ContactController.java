package com.protfilo.demo.controller;

import com.protfilo.demo.dto.ContactDto;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final JavaMailSender mailSender;

    public ContactController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody ContactDto dto) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("hassenchlady@gmail.com");
        mail.setSubject("New Portfolio Message");
        mail.setText(
                "Name: " + dto.getName() + "\n" +
                        "Email: " + dto.getEmail() + "\n\n" +
                        dto.getMessage()
        );

        mailSender.send(mail);
        return ResponseEntity.ok("Message sent");
    }
}
