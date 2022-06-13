package com.practice.springjpasecurity.controller;

import com.practice.springjpasecurity.dto.UserListDto;
import com.practice.springjpasecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping(value = "/getUserList"/*, produces="application/json;charset=UTF-8"*/)
    @ResponseBody
    public UserListDto getAllUser() {
        UserListDto userListDto = new UserListDto();
        userListDto.setUserEntities(userService.getAllUser());
        return userListDto;
    }
}