package com.project.api_e_commerce.dao;

import com.project.api_e_commerce.entity.User;
import com.project.api_e_commerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserDao {
    UserRepository userRepository;


    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

//    implementation for this method existsByEmail() is given by spring container itself
    public boolean isEmailUnique(String email)
    {
        return !userRepository.existsByEmail(email);
    }

//    implementation for this method existsByMobile() is given by spring container itself
    public boolean isMobileUnique(Long mobile)
    {
        return !userRepository.existsByMobile(mobile);
    }

}
