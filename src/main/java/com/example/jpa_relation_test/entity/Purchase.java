package com.example.jpa_relation_test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@ToString
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference
    private Member member;

    @ManyToOne
    private Book book;
}
