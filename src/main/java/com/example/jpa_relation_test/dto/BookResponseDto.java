package com.example.jpa_relation_test.dto;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Integer price;
    private Integer stock;
    private BookStore bookStore;

    public BookResponseDto(Book book) {
        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        price = book.getPrice();
        stock = book.getStock();
        bookStore = book.getBookStore();
    }
}
