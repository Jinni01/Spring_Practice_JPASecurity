package com.practice.springjpasecurity.controller;

import com.practice.springjpasecurity.dto.CreateUserDto;
import com.practice.springjpasecurity.dto.UserListDto;
import com.practice.springjpasecurity.service.MasterService;
import com.practice.springjpasecurity.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/master")
@RequiredArgsConstructor
public class MasterController {

    private final MasterService masterService;

    @PostMapping(value = "/registerUser")
    @ResponseBody
    public boolean createUser(CreateUserDto createUserDto) {
        return masterService.createUser(
                createUserDto.getId(),
                createUserDto.getPassword(),
                createUserDto.getName(),
                createUserDto.getAuthorities());
    }
}
