package com.buszek.repositories;

import com.buszek.models.Book;
import com.buszek.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StubBookRepository implements BookService {

    private final Map<Long, Book> books = new HashMap<>();

    public StubRepository() {
        books.put(1L, new Book(1L, "Miecz przeznaczenia", "Andrzej Sapkowski", "9788375780642", "superNOWA", "fantasy"));
        books.put(2L, new Book(2L, "'Conan i łówcy głów", "John Maddox Roberts", "8371693087", "Amber", "fantasy"));
        books.put(3L, new Book(3L, "Bez litości. Prawdziwa historia zespołu Slayer", "Jarek Szubrycht", "9788387598488", "Kagra", "muzyka"));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(long id) {
        return books.get(id);
    }

    @Override
    public Book save(Book book) {
//        book.setId(getNextId());
        books.put(book.getId(), book);
        return book;
    }
}
