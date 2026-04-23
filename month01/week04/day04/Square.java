import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Тал: ");
        int a = scanner.nextInt();

        double b = 1.41421;
        float s = a * a;
        float p = a * 4;
        double d = a * b;

        System.out.println("Талбай: " +s);
        System.out.println("Периметр: " +p);
        System.out.println("Диагонал: " +d);

        scanner.close();
    }
}
