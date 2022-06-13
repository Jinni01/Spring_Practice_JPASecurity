package com.practice.springjpasecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "authority")
@Table(schema = "jpasecurity", name = "authority")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityEntity {
    @Id
    @Column(name = "authority_sn")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authoritySn;

    private String authority;

    @ManyToMany(mappedBy = "authorityEntities")
    @JsonBackReference
    private List<UserEntity> userEntities = new ArrayList<>();
}
