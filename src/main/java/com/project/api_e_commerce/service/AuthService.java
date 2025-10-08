package com.project.api_e_commerce.service;

import com.project.api_e_commerce.dto.ResponseDto;
import com.project.api_e_commerce.dto.UserDto;

public interface AuthService {

    ResponseDto register(UserDto userDto);
}
