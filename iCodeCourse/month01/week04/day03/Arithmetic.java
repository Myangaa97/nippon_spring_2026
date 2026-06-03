import java.util.Scanner;
public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        int x = scanner.nextInt();
        System.out.println("Second number: ");
        int y = scanner.nextInt();

        System.out.println(x + " + " + y + " = " + (x + y));
        System.out.println(x + " - " + y + " = " + (x - y));
        System.out.println(x + " * " + y + " = " + (x * y));
        System.out.println(x + " / " + y + " = " + ( x / y));
        System.out.println(x + " / " + y + " = " + ( x % y));

        scanner.close();
    }
}