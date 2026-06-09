package main;

import model.Book;
import model.Novel;
import model.TextBook;

public class UnshZar {
    public static void main(String[] args) {
        Book b1 = new Novel(1, "Harry Potter", "Rowling", 20, "Fantasy");
        Book b2 = new TextBook(2, "Math 101", "Smith", 15, "Math");
        Book b3 = new TextBook(3, "Math 102", "Small", 15, "Math");

        b1.about();
        b2.about();
        b3.about();
    }
}