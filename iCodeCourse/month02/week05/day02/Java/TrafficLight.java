import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Гэрлийн өнгө (red/yellow/green): ");
        String color = scanner.next();

        if (color.equals("green")) {
            System.out.println("Явж болно.");
        } else if (color.equals("red")) {
            System.out.println("Зогс!");
        } else if (color.equals("yellow")) {
            System.out.println("Бэлэн бол.");
        } else {
            System.out.println("Буруу өнгө.");
        }
        scanner.close();
    }
}
