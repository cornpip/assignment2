package com.example.jpa_relation_test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
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
    @JsonManagedReference
    private BookStore bookStore;

    @OneToMany(mappedBy = "member")
    @JsonBackReference
    private List<Purchase> purchases = new ArrayList<>();
}
