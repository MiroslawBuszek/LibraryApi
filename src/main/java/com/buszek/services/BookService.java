package com.buszek.services;

import com.buszek.models.Book;
import java.util.List;

public interface BookService {

    List<Book> findAllBook();

    Book findBookById(long id);

    Book saveBook(Book book);

    Book updateBook(long id, Book book);

    Book deleteBook(long id);

}
