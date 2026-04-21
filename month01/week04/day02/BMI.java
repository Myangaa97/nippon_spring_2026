import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me Weight");
        int weight = scanner.nextInt();
        System.out.println("Give me height");
        double height = scanner.nextDouble();

        double x = weight / (height * height);
        System.out.println("BMI: " + x);

        scanner.close();
    }
}
