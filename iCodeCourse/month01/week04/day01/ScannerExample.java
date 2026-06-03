import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("give me name");
        String name = scanner.nextLine();

        System.out.println("Give me your age");
        int age = scanner.nextInt();

        System.out.println("Hello, " + name + "!You are " + age + "years old");

        scanner.close();
    }
}
