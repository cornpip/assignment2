package com.example.jpa_relation_test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "SpartaStoreId")
    private BookStore bookStore;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases = new ArrayList<>();
}
