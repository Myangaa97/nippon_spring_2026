package com.icode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookApi {
	
	public record Book(int id, String title, String author, int pages) {}
    public record bookResponse(int totalPages) {}
    
    private final List<Book> books = List.of(
            new Book(1, "Clean Code", "Robert Martin", 464),
            new Book(2, "Effective Java", "Joshua Bloch", 416),
            new Book(3, "Java Basics", "Saraa", 220),
            new Book(4, "Spring Up", "Saraa", 310)
    );

    @GetMapping("api/books")
    public List<Book> getBooks() {
        return books;
    }
    
    @GetMapping("/api/books/{id}")
    public Book bookById(@PathVariable int id) {
    	for (Book book : books) {
			if (book.id() == id) {
				return book;
			}
		}
		return null;
    }
    
    @GetMapping("api/books/{id}/title")
<<<<<<< HEAD
    public String getBookTitle(@PathVariable int id) {
    	for (Book book : books) {
    		if (book.id() == id) {
				return book.title();
=======
    public String bookTitleById(@PathVariable int id) {
    	List<Book> filteredBookTitle = new ArrayList<>();
    	for (Book b : books) {
			if (b.id()== id) {
				filteredBookTitle.add(b);
>>>>>>> 6e4e8e061b6715b7d794d8ecfcc589ae4a8bd6fd
			}
		}
    	return b.title();
    }
   

    @GetMapping("/api/books/count")
    public int booksCount() {
        return books.size();
    }

    @GetMapping("/api/books/search")
    public List<Book> search(@RequestParam String author) {
    	List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.author().equals(author)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
}
