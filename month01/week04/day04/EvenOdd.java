import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Number");
        int n = scanner.nextInt();

        int x = n%2;
        System.out.println(n + " % 2 = " + x);

        scanner.close();
    }
}