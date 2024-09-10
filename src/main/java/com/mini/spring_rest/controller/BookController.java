package com.mini.spring_rest.controller;

import com.mini.spring_rest.entity.Book;
import com.mini.spring_rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController{

    @Autowired
    private BookService bookServ;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookServ.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional<Book> book = bookServ.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookServ.createBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookServ.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}