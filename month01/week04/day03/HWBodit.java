import java.util.Scanner;

public class HWBodit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        double x = scanner.nextDouble();
        System.out.println("Second number: ");
        double y = scanner.nextDouble();

        System.out.println(x + " + " + y + " = " + (x + y));
        System.out.println(x + " - " + y + " = " + (x - y));
        System.out.println(x + " * " + y + " = " + (x * y));
        System.out.println(x + " / " + y + " = " + ( x / y ));

        scanner.close();
    }
}
