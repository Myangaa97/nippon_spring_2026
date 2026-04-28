import java.util.Scanner;

public class J4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nasaa oruulna uu:");
        int age = scanner.nextInt();
        System.out.println("Vldegdel oruulna uu:");
        int price = scanner.nextInt();

        if ((age > 21) && age < 65 && price > 500000) {
            System.out.println("Тэнцсэн");
        }
        else {
            System.out.println("Тэнцээгүй");
        }
        scanner.close();
    }
}