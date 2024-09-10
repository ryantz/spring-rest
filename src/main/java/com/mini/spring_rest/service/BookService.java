package com.mini.spring_rest.service;

import com.mini.spring_rest.entity.Book;
import com.mini.spring_rest.repository.BookRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }

    public Book createBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteBook(long id){
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }else{
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

}
