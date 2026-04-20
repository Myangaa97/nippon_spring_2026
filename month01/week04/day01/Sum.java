import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("first number pls");
        int num1 = scanner.nextInt();

        System.out.println("second number pls");
        int num2 = scanner.nextInt();

        int x = num1 + num2;
        System.out.println("Sum: " +x);
        scanner.close();

    }
}
