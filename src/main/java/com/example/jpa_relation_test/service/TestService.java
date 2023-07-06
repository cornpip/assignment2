package com.example.jpa_relation_test.service;

import com.example.jpa_relation_test.dto.BookDto;
import com.example.jpa_relation_test.dto.BookResponseDto;
import com.example.jpa_relation_test.dto.MemberResponseDto;
import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.entity.Purchase;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import com.example.jpa_relation_test.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookStoreRepository bookStoreRepository;
    private final PurchaseRepository purchaseRepository;

    @Transactional
    public MemberResponseDto signup(Member member) {
        Member save = memberRepository.save(member);
        return new MemberResponseDto(save);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public BookResponseDto updateBook(Book requestBook, Long bookStoreId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("비었습니다."));
        book.setStock(requestBook.getStock());
        return new BookResponseDto(book);
    }
//    public ListResponseDto findBook(Long bookStoreId) {
//        List<Book> bookList = bookRepository.findByBookStoreId(bookStoreId);
//        return new ListResponseDto(bookList);
//    }

    @Transactional
    public void transferBook(Long bookId, Long bookStoreId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow();
        BookStore bookStore = bookStoreRepository.findById(bookStoreId)
                .orElseThrow();
        bookStore.addBook(book);
        book.setBookStore(bookStore);
    }

    public List<Purchase> findAllPurchase() {
        return purchaseRepository.findAll();
    }

    public List<BookStore> findAllBookStore() {
        List<BookStore> all = bookStoreRepository.findAll();
//        List<Book> bookList = all.get(0).getBookList();
//        System.out.println(bookList);
        return all;
    }

    public List<BookDto.Response> findAllBook() {
        List<Book> all = bookRepository.findAll();
        BookDto.Response response = new BookDto.Response(all.get(0));
        System.out.println(response);
        return all.stream().map(BookDto.Response::new).collect(Collectors.toList());
//        return null;
    }
}
