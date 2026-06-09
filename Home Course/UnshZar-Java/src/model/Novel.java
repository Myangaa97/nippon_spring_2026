package model;

public class Novel extends Book {
    private String genre;

    public Novel(int bookId, String title, String author, double price, String genre) {
        super(bookId, title, author, price);
        this.genre = genre;
    }

    @Override
    public void about() {
        System.out.println(
                "Novel -> " + title +
                        " | Author: " + author +
                        " | Genre: " + genre +
                        " | Price: " + price
        );
    }
}