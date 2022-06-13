package com.practice.springjpasecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserDto {
    private String id;
    private String password;
    private String name;
    private List<String> authorities;
}
