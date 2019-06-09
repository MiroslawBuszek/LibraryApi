package com.buszek.controllers;

import com.buszek.models.Book;
import com.buszek.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return booksService.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book) {
        return booksService.update(id, book);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable long id) {
        return booksService.delete(id);
    }
}
