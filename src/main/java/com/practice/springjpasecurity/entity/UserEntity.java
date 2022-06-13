package com.practice.springjpasecurity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity(name="user")
@Table(schema = "jpasecurity", name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_sn")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSn;

    @Column(unique = true)
    private String id;

    private String password;

    private String name;
    @ManyToMany
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_sn"),
            inverseJoinColumns = @JoinColumn(name = "authority_sn"))
    @JsonManagedReference
    private List<AuthorityEntity> authorityEntities = new ArrayList<>();
}
