package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberResponseDto {
    private Long id;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String nickname;
    private String bookStore = "";

    public MemberResponseDto(Member member) {
        id = member.getId();
        email = member.getEmail();
        password = member.getPassword();
        address = member.getAddress();
        phoneNumber = member.getPhoneNumber();
        nickname = member.getNickname();
    }
}
