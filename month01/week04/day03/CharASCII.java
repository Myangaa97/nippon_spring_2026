import java.util.Scanner;

public class CharASCII {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Том үсэг оруулна уу: ");
        char upper = scanner.next().charAt(0);

        int code = (int) upper;
        System.out.println("ASCII код: " + code);

        char lower = (char) (upper + 32);
        System.out.println("Жижиг үсэг: " + lower);

        scanner.close();
    }
}
