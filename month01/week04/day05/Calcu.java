import java.util.Scanner;

public class Calcu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First number: ");
        int x = scanner.nextInt();
        System.out.println("Second number: ");
        int y = scanner.nextInt();
        System.out.println("Үйлдэл (+, -, *, /): ");
        char c = scanner.next().charAt(0);
        

        System.out.println(x + " " + c + " " + y = (x ));

        scanner.close();
    }
}