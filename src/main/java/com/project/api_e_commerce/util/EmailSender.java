package com.project.api_e_commerce.util;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    public void sendOtp(String email, int otp, String name)
    {
        System.out.println("The otp is : "+otp);
    }
}
