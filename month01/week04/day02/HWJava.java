import java.util.Scanner;

public class HWJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gurwaljin urt oruul: ");
        int width = scanner.nextInt();
        System.out.println("Gurwaljin urgun oruul: ");
        int height = scanner.nextInt();

        int s = width * height;
        int p = (width + height) * 2;

        System.out.println("Gurwaljin S = " + s);
        System.out.println("Gurwaljin P = " + p);

        scanner.close();
    }
}
