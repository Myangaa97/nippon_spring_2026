import java.util.Scanner;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Нууц үг оруулна уу: ");
        String pwd = scanner.next();

        boolean hasUpper = !pwd.equals(pwd.toLowerCase());
        boolean hasDigit = pwd.matches(".*\\d.*");
        int len = pwd.length();

        if (len >= 8 && hasDigit && hasUpper) {
            System.out.println("Strong");
        } else if (len >= 6 && (hasDigit || hasUpper)) {
            System.out.println("Middle");
        } else {
            System.out.println("Weak");
        }
        scanner.close();
    }
}
