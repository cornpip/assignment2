package com.example.jpa_relation_test.controller;

import com.example.jpa_relation_test.dto.BookDto;
import com.example.jpa_relation_test.dto.BookResponseDto;
import com.example.jpa_relation_test.dto.MemberResponseDto;
import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.entity.Purchase;
import com.example.jpa_relation_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/member")
    public MemberResponseDto signup(@RequestBody Member member) {
        return testService.signup(member);
    }

    @GetMapping("/member")
    public List<Member> findAllMember() {
        return testService.findAllMember();
    }

    @GetMapping("/book")
    public List<BookDto.Response> findAllbook(){
        return testService.findAllBook();
    }

    @GetMapping("/purchase")
    public List<Purchase> findAllPurchase(){
        return testService.findAllPurchase();
    }

    @GetMapping("/bookstore")
    public List<BookStore> findAllBookStore(){
        return testService.findAllBookStore();
    }

    @PutMapping("/bookstore/{bookStoreId}/book/{bookId}")
    public BookResponseDto updateBook(@RequestBody Book book,
                                      @PathVariable("bookStoreId") Long bookStoreId,
                                      @PathVariable("bookId") Long bookId) {
        return testService.updateBook(book, bookStoreId, bookId);
    }

//    @GetMapping("/bookstore/{bookStoreId}/book")
//    public ListResponseDto findBook(@PathVariable("bookStoreId") Long bookStoreId) {
//        return testService.findBook(bookStoreId);
//    }

    @PostMapping("/bookstore/{bookStoreId}/book/{bookId}")
    public void transferBook(@PathVariable("bookId") Long bookId,
                             @PathVariable("bookStoreId") Long bookStoreId) {
        testService.transferBook(bookId, bookStoreId);
    }


}
