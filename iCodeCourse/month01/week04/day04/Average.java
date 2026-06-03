import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        System.out.println("Input numbers");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1st number: ");
        int a = scanner.nextInt();
        System.out.println("2nd number: ");
        int b = scanner.nextInt();
        System.out.println("3rd number: ");
        int c = scanner.nextInt();
        System.out.println("4th number: ");
        int d = scanner.nextInt();
        System.out.println("5th number: ");
        int e = scanner.nextInt();
        
        int s = (a+b+c+d+e)/5;

        System.out.println("Average is: " +s);

        scanner.close();
    }
}
