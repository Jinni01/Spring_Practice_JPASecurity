package com.practice.springjpasecurity.service;

import com.practice.springjpasecurity.entity.AuthorityEntity;
import com.practice.springjpasecurity.entity.UserEntity;
import com.practice.springjpasecurity.repository.AuthorityRepository;
import com.practice.springjpasecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MasterService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean createUser(String id, String password, String name, List<String> authorities) {

        if (CollectionUtils.isEmpty(authorities)) {
            return false;
        }

        if (checkUserIdExist(id)) {
            return false;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setName(name);

        final List<AuthorityEntity> authorityEntities =
                authorities.stream()
                        .map(authorityRepository::findByAuthority)
                        .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(authorityEntities)) {
            return false;
        }

        userEntity.setAuthorityEntities(authorityEntities);
        userRepository.save(userEntity);

        return true;
    }

    private boolean checkUserIdExist(String id) {
        UserEntity userEntity = userRepository.findById(id);

        return Objects.nonNull(userEntity);
    }
}
