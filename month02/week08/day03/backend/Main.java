public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Суурь", "Батаа", 320, 25000);
        Book b2 = new Book("CSS Гарын авлага", "Сарнай", 180, 18000);
        Book b3 = new Book("Алгоритм", "Дорж", 450, 32000);

        b1.showInfo();
        b2.showInfo();
        b3.showInfo();

        System.out.println("\nb1 b2-оос урт уу? " + b1.isLonger(b2));  // true
        System.out.println("b2 b3-аас хямд уу? " + b2.isCheaper(b3)); // true

        // Хамгийн их хуудастай
        Book longest = b1;
        if (b2.isLonger(longest)) longest = b2;
        if (b3.isLonger(longest)) longest = b3;
        System.out.println("\nХамгийн урт ном: " + longest.title + " (" + longest.pages + " хуудас)");
    }
}