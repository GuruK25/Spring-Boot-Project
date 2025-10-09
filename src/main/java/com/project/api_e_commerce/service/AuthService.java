package com.project.api_e_commerce.service;

import com.project.api_e_commerce.dto.OtpDto;
import com.project.api_e_commerce.dto.ResponseDto;
import com.project.api_e_commerce.dto.UserDto;

import java.util.concurrent.TimeoutException;

public interface AuthService {

    ResponseDto register(UserDto userDto);

    ResponseDto verifyOtp(OtpDto otpDto) throws TimeoutException;
}
