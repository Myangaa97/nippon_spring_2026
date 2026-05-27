class Book {
    String title;
    String author;
    int pages;
    double price;

    Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    boolean isLonger(Book other) {
        return this.pages > other.pages;
    }

    boolean isCheaper(Book other) {
        return this.price < other.price;
    }

    void showInfo() {
        System.out.println("\"" + title + "\" — " + author +
            " (" + pages + " хуудас, " + price + "₮)");
    }
}