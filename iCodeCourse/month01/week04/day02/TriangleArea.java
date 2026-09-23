import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Suuriin urt oruul: ");
        int a = scanner.nextInt();

        System.out.println("Undur oruul: ");
        int h = scanner.nextInt();

        float x = a * h / 2;
        System.out.println("S = " + x);

        scanner.close();
    }
}
