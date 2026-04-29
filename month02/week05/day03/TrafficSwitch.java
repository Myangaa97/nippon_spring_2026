import java.util.Scanner;

public class TrafficSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Гэрэл (red,green, yellow): ");
        String color = scanner.next();

        switch (color) {
            case "red":
                System.out.println("Зогс!");
                break;
            case "yellow":
                System.out.println("Болгоомжтой!");
                break;
            case "green":
                System.out.println("Яв!");
                break;
            default:
                System.out.println("Тодорхойгүй");
        }

        scanner.close();
    }
}
