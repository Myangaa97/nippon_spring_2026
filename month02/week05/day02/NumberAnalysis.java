import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Тоо оруулна уу: ");
        int n = scanner.nextInt();
        int x;
        if (n > 0) {
            System.out.println("Eyreg too");
        } else if (n < 0) {
            System.out.println("Surug too");
        } else {
            System.out.println("0");
        }

        if (n % 2 == 0) {
            System.out.println("Tegsh too");
        } else {
            System.out.println("Sondgoi too");
        }

        if (n % 5 == 0) {
            System.out.println("5-d huwaagdana");
        } else {
            System.out.println("5-d huwaagdahgvi");
        }

        if (n < 0) {
            x = n * (-1);
            if (x / 10 > 0 && x / 10 < 10) {
                System.out.println("2 orontoi");
            } else if (x / 1 == x && x < 10) {
                System.out.println("1 orontoi");
            } else {
                System.out.println("3 ba tvvnees deesh orontoi");
            }
        }
        scanner.close();
    }
}
