import java.util.Scanner;

public class TotalMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me Hours");
        int hour = scanner.nextInt();

        System.out.println("Give me Minutes");
        int minu = scanner.nextInt();

        int x = hour * 60 + minu;
        System.out.println("Total: " + x + " minutes");

        scanner.close();
    }
}