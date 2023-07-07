package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.entity.Purchase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {

    @Getter
    @ToString
    public static class Response {
        private Long id;
        private String title;
        private String author;
        private Integer price;
        private Integer stock;
        private BookStoreDto bookStoreDto;
        private List<PurchaseDto> purchaseDtoList;

        public Response(Book entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.price = entity.getPrice();
            this.stock = entity.getStock();
            this.bookStoreDto = new BookStoreDto(entity.getBookStore());
            this.purchaseDtoList = entity.getPurchases().stream().map(PurchaseDto::new).collect(Collectors.toList());
        }
    }

    @Getter
    @ToString
    private static class BookStoreDto {
        private Long id;
        private String name;
        private String address;

        public BookStoreDto(BookStore entity) {
            this.id = entity.getId();
            this.name = entity.getName();
            this.address = entity.getAddress();
        }
    }

    @Getter
    @ToString
    private static class PurchaseDto {
        private Long id;
        MemberDto memberDto;

        public PurchaseDto(Purchase entity) {
            this.id = entity.getId();
            this.memberDto = new MemberDto(entity.getMember());
        }
    }

    @Getter
    @ToString
    private static class MemberDto {
        private Long id;
        private String email;
        private String password;
        private String address;
        private String phoneNumber;
        private String nickname;
        // 다른 지점 member가 구입했을 수도 있으니까
        private BookStoreDto bookStoreDto;

        public MemberDto(Member member) {
            this.id = member.getId();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.address = member.getAddress();
            this.phoneNumber = member.getPhoneNumber();
            this.nickname = member.getNickname();
            this.bookStoreDto = new BookStoreDto(member.getBookStore());
        }
    }
}
