package com.practice.springjpasecurity.service;

import com.practice.springjpasecurity.entity.AuthorityEntity;
import com.practice.springjpasecurity.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AuthorityRepository authorityRepository;

    public List<AuthorityEntity> getAllAuthority() {
        return authorityRepository.findAll();
    }
}
