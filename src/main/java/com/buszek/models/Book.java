package com.buszek.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    Long id;
    String title;
    String author;
    String bookNumber;
    String publisher;
    String typeBook;

    public void update(Book other) {

        if (other != null) {

            if (other.getBookNumber() != null) {
                bookNumber = other.getBookNumber();
            }

            else if (other.getTitle() != null) {
                title = other.getTitle();
            }

            else if (other.getAuthor() != null) {
                author = other.getAuthor();
            }

            else if (other.getPublisher() != null) {
                publisher = other.getPublisher();
            }

            else if (other.getTypeBook() != null) {
                typeBook = other.getTypeBook();
            }
        }
    }
}
