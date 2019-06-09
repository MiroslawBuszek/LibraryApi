package com.buszek.repositories;

import com.buszek.models.Book;
import com.buszek.services.BookService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class StubBookRepository implements BookService {

    private final Map<Long, Book> books = new HashMap<>();

    public StubBookRepository() {
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
        book.setId(getNextId());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(long id, Book book) {

        final Book bookToUpdate = findById(id);

        if (bookToUpdate == null) {
            return null;
        }

        bookToUpdate.updateBook(book);
        return bookToUpdate;
    }

    @Override
    public Book delete(long id) {

        if (books.containsKey(id)) {
            return books.remove(id);
        }

        return null;
    }

    private long getNextId() {

        if (books.isEmpty()) {
            return 1L;
        }

        final List<Long> keys = new ArrayList<>(books.keySet());
        keys.sort(Comparator.reverseOrder());
        return keys.get(0) + 1L;
    }
}
