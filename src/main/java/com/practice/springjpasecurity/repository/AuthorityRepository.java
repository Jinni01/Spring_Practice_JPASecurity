package com.practice.springjpasecurity.repository;

import com.practice.springjpasecurity.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {
    public AuthorityEntity findByAuthority(String authority);
}
