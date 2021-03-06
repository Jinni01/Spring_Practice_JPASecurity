package com.practice.springjpasecurity.controller;

import com.practice.springjpasecurity.dto.AuthorityListDto;
import com.practice.springjpasecurity.dto.UserListDto;
import com.practice.springjpasecurity.service.AdminService;
import com.practice.springjpasecurity.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final AdminService adminService;

    @GetMapping(value = "/getUserList"/*, produces="application/json;charset=UTF-8"*/)
    @ResponseBody
    public UserListDto getAllUser() {
        UserListDto userListDto = new UserListDto();
        userListDto.setUserEntities(userService.getAllUser());
        return userListDto;
    }

    @GetMapping(value = "/getAuthorityList")
    @ResponseBody
    public AuthorityListDto getAllAuthority() {
        AuthorityListDto authorityListDto = new AuthorityListDto();
        authorityListDto.setAuthorityEntities(adminService.getAllAuthority());
        return authorityListDto;
    }
}