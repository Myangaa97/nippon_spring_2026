import java.util.Scanner;

public class BirthYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Нэрээ оруулна уу: ");
        String name = scanner.nextLine();

        System.out.println("Насаа оруулна уу: ");
        int age = scanner.nextInt();

        int year = 2026 - age;
        System.out.println(name + " " + age + " настай, " + year + " онд төрсөн.");

        scanner.close();
    }
}
