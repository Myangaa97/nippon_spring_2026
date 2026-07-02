package com.icode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    public record Book(int id, String title, String author, int pages) {}
    public record TotalPagesResponse(int totalPages) {}

    private final List<Book> books = List.of(
            new Book(1, "Clean Code", "Robert Martin", 464),
            new Book(2, "Effective Java", "Joshua Bloch", 416),
            new Book(3, "Java Basics", "Saraa", 220),
            new Book(4, "Spring Up", "Saraa", 310)
    );

// Exercise 4
    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }
    
// Exercise 5
    @GetMapping("/api/books/search")
    public List<Book> getByAuthor(@RequestParam String author) {

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.author().equals(author)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
    
// Exercise 6
    @GetMapping("/books/longest")
    public Book getLongestBook() {

        Book longestBook = books.get(0);

        for (Book book : books) {
            if (book.pages() > longestBook.pages()) {
                longestBook = book;
            }
        }

        return longestBook;
    }
    
// Exercise 7
    @GetMapping("/api/books/pages/total")
    public TotalPagesResponse getTotalPages() {

        int totalPages = 0;

        for (Book book : books) {
            totalPages += book.pages();
        }

        return new TotalPagesResponse(totalPages);
    }
    
// Exercise 8
    
}