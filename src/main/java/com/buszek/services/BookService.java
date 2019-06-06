package com.buszek.services;

import com.buszek.models.Book;
import java.util.List;


public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    Book save(Book book);

    Book update(long id, Book book);

    Book delete(long id);

}
