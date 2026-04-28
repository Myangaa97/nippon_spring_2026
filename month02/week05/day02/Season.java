import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сар оруулна уу (1-12): ");
        int month = scanner.nextInt();

        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Өвөл");
        } else if (month == 3 || month == 4 || month == 5) {
            System.out.println("Хавар");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println("Зун");
        } else {
            System.out.println("Намар");
        }
        scanner.close();
    }
}
