package com.practice.springjpasecurity.security;

import com.practice.springjpasecurity.entity.AuthorityEntity;
import com.practice.springjpasecurity.entity.UserEntity;
import com.practice.springjpasecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final static String ROLE_PREFIX = "ROLE_";

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserEntity userEntity = userRepository.findById(username);
            if (Objects.isNull(userEntity)) {
                throw new UsernameNotFoundException(username);
            }

            List<GrantedAuthority> roles = getRoles(userEntity.getAuthorityEntities());

        return User.builder()
                    .username(userEntity.getId())
                    .password(userEntity.getPassword())
                    .authorities(roles)
                    .build();
        }

        private List<GrantedAuthority> getRoles(List<AuthorityEntity> authorityEntities) {
            return authorityEntities.stream()
                .map(AuthorityEntity::getAuthority)
                .map(authority -> {
                    return new SimpleGrantedAuthority(ROLE_PREFIX + authority);
                })
                .collect(Collectors.toList());
    }
}
