import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a - too oruulna uu: ");
        float a = scanner.nextFloat();
        System.out.println("b - too oruulna uu");
        float b = scanner.nextFloat();
        System.out.println("Temdegt oruulna uu (+,-,*,/): ");
        char c = scanner.next().charAt(0);
        
        if ( b != 0 ) {
            switch (c) {
            case '+':
                System.out.printf("%.2f + %.2f = %.2f", a, b, (a+b));
                break;
            case '-':
                System.out.printf("%.2f + %.2f = %.2f", a, b, (a-b));
                break;
            case '*':
                System.out.printf("%.2f + %.2f = %.2f", a, b, (a*b));
                break;
            case '/':
                System.out.printf("%.2f + %.2f = %.3f", a, b, (a/b));
                break;
            default:
                System.out.println("Тодорхойгүй");
            }
        } else {
            System.out.println("b too 0s ylgaatai too oruul");

        }

        System.out.println();
        scanner.close();
    }
}
