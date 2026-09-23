import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a тал: ");
        int a = scanner.nextInt();
        System.out.print("b тал: ");
        int b = scanner.nextInt();
        System.out.print("c тал: ");
        int c = scanner.nextInt();

        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            if (a == b && a == c && b == c) {
                System.out.println("Тэгш талт");
            } else if (a == b || a == c || c == b) {
                System.out.println("Тэгш хоёр талт");
            } else {
                System.out.println("Ерийн");
            }
        } else {
            System.out.println("Гурвалжин биш");
        }

        scanner.close();
    }
}
