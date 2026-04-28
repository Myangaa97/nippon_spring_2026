import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Оноо оруулна уу: ");
        int score = scanner.nextInt();

        if (score <= 100 && score >= 90) {
            System.out.println("Дүн: A");
        } else if (score < 89 && score >= 80) {
            System.out.println("Дүн: B");
        } else if (score < 79 && score >= 70) {
            System.out.println("Дүн: C");
        } else if (score < 69 && score >= 60) {
            System.out.println("Дүн: D");
        } else if (score < 59 && score >= 0) {
            System.out.println("Дүн: F");
        } else {
            System.out.println("Буруу оноо");
        }
        scanner.close();
    }
}
