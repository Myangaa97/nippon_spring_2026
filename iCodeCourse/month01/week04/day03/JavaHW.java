import java.util.Scanner;

public class JavaHW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нийт минут: ");
        int a = scanner.nextInt();

        int x = a / 60;
        int y = a % 60;
        
        System.out.println(x + " цаг " + y + " минут ");

        scanner.close();
    }
}
