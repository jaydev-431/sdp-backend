package com.klef.sdp.sdpbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCredentials(String toEmail, String username, String password) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Account Created - Login Credentials");

            message.setText(
                "Hello,\n\n" +
                "Your account has been created successfully.\n\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n\n" +
                "Please login ..\n\n" +
                "Regards,\nAdmin"
            );

            mailSender.send(message);
            System.out.println("Email sent to " + toEmail);

        } catch (Exception e) {
            System.out.println(" Email sending failed: " + e.getMessage());
        }
    }
}