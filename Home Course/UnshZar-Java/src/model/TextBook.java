package model;

public class TextBook extends Book {
    private String subject;

    public TextBook(int bookId, String title, String author, double price, String subject) {
        super(bookId, title, author, price);
        this.subject = subject;
    }

    @Override
    public void about() {
        System.out.println(
                "TextBook -> " + title +
                        " | Author: " + author +
                        " | Subject: " + subject +
                        " | Price: " + price
        );
    }
}