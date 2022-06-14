package com.practice.springjpasecurity.dto;

import com.practice.springjpasecurity.entity.AuthorityEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorityListDto {
    private List<AuthorityEntity> authorityEntities;
}
