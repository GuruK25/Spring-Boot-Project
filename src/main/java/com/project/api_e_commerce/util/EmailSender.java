package com.project.api_e_commerce.util;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailSender {

    JavaMailSender mailSender;

    public void sendOtp(String email, int otp, String name)
    {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("OTP for creating Account with Ecomm Website");
            message.setText("Hello,"+ name + " Thank you for Creating account with us, Your Otp is " + otp+" It is valid only for 5 minutes.");
            mailSender.send(message);

        }catch (Exception e)
        {
            System.err.println("The otp is " + otp);
        }
    }

}
