package com.buszek.controllers;

import com.buszek.models.Book;
import com.buszek.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService booksService;

    @Autowired
    public BookController(BookService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return booksService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id) {
        return booksService.findById(id);
    }

}
