package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BookDto {

    @Getter
    @ToString
    public static class Response {
        private Long id;
        private String title;
        private String author;
        private Integer price;
        private Integer stock;
        private BookStoreDto bookStore;

        public Response(Book entity) {
            this.id = entity.getId();
            this.title = entity.getTitle();
            this.author = entity.getAuthor();
            this.price = entity.getPrice();
            this.stock = entity.getStock();
            this.bookStore = new BookStoreDto(entity.getBookStore());
        }
    }

    @Getter
    @ToString
    public static class BookStoreDto {
        private Long id;
        private String name;
        private String address;
        public BookStoreDto(BookStore entity){
            this.id = entity.getId();
            this.name = entity.getName();
            this.address = entity.getAddress();
        }
    }
}
