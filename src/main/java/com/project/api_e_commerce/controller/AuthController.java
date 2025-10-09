package com.project.api_e_commerce.controller;

import com.project.api_e_commerce.dto.OtpDto;
import com.project.api_e_commerce.dto.ResponseDto;
import com.project.api_e_commerce.dto.UserDto;
import com.project.api_e_commerce.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api/v1/user/auth")
@AllArgsConstructor
public class AuthController {

    AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(code= HttpStatus.CREATED)
    public ResponseDto register(@Valid @RequestBody UserDto userDto)
    {
        return authService.register(userDto);
    }

    @PostMapping("/verify-otp")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseDto verifyOtp(@RequestBody OtpDto otpDto) throws TimeoutException
    {
        return authService.verifyOtp(otpDto);
    }



}
