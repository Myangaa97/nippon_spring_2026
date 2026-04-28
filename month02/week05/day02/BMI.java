import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Жин (кг): ");
        double weight = scanner.nextDouble();
        System.out.print("Өндөр (м): ");
        double height = scanner.nextDouble();

        double x;
        x = (weight) / (height * height);

        if (x < 18.5) {
            System.out.println("Туранхай");
        } else if (x > 18.5 && x < 24.9) {
            System.out.println("Хэвийн");
        } else if (x > 25 && x < 29.9) {
            System.out.println("Илүүдэл жинтэй");
        } else {
            System.out.println("Таргалалт");
        }
        scanner.close();
    }
}
