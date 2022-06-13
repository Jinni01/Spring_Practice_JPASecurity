package com.practice.springjpasecurity.dto;

import com.practice.springjpasecurity.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListDto {
    private List<UserEntity> userEntities;
}
