import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нийт секунд: ");
        int a = scanner.nextInt();

        int x = a / 3600;
        int y = a % 3600 / 60;
        int z = a % 3600 % 60;
        
        System.out.println(x + " цаг " + y + " минут " + z + " секунд ");

        scanner.close();
    }
}
