import java.util.Scanner;

public class HWD201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me length: ");
        int length = scanner.nextInt();
        System.out.println("Give me width: ");
        int width = scanner.nextInt();

        int s = length * width;
        int p = (length + width) * 2;

        System.out.println("S: " + s);
        System.out.println("P: " + p);

        scanner.close();
    }
}
