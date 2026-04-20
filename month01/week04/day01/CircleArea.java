import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Radius Pls");
        int rad = scanner.nextInt();

        double x = 3.14159 * rad^2;

        System.out.println("S= " +x%.5f);
        scanner.close();
    }
}
