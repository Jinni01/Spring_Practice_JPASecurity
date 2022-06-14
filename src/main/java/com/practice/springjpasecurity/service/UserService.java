package com.practice.springjpasecurity.service;

import com.practice.springjpasecurity.entity.UserEntity;
import com.practice.springjpasecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
}
