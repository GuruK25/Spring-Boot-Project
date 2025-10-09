package com.project.api_e_commerce.service.impl;

import com.project.api_e_commerce.dao.UserDao;
import com.project.api_e_commerce.dto.OtpDto;
import com.project.api_e_commerce.dto.ResponseDto;
import com.project.api_e_commerce.dto.UserDto;
import com.project.api_e_commerce.entity.Role;
import com.project.api_e_commerce.entity.User;
import com.project.api_e_commerce.exception.DataExistsException;
import com.project.api_e_commerce.service.AuthService;
import com.project.api_e_commerce.util.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserDao userDao;
    PasswordEncoder encoder;
    EmailSender emailSender;


    @Override
    public ResponseDto register(UserDto userDto) {
        if(userDao.isEmailUnique(userDto.getEmail()) && userDao.isMobileUnique(userDto.getMobile()))
        {
            int otp = new Random().nextInt(100000, 1000000);
            emailSender.sendOtp(userDto.getEmail(), otp, userDto.getName());

            userDao.saveUser(new User(null,
                    userDto.getName(),
                    userDto.getEmail(),
                    encoder.encode(userDto.getPassword()),
                    userDto.getMobile(),
                    null,
                    otp,
                    LocalDateTime.now().plusMinutes(5),
                    Role.valueOf("ROLE_"+userDto.getRole().toUpperCase()),
                    false));

            return new ResponseDto("Otp sent success, Verify within 5 minutes", userDto);
        }
        else
        {
            if(!userDao.isEmailUnique(userDto.getEmail()))
            {
                throw new DataExistsException("Email Already exists: "+userDto.getEmail());
            }
            else {
                throw new DataExistsException("Mobile Already exists: "+userDto.getMobile());
            }
        }
    }

    @Override
    public ResponseDto verifyOtp(OtpDto otpDto) throws TimeoutException {
        User user = userDao.findByEmail(otpDto.getEmail());

        if(LocalDateTime.now().isBefore(user.getOtpExpiryTime()))
        {
            if(otpDto.getOtp() == user.getOtp())
            {
                user.setStatus(true);
                user.setOtp(0);
                user.setOtpExpiryTime(null);
                return new ResponseDto("Account Created Success", user );
            }
            else {
                throw new InputMismatchException("Otp mismatch, Try again");
            }
        }
        else {
            throw new TimeoutException("Otp expired, Resend otp and try again");
        }
    }
}
