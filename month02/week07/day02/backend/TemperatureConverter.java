import java.util.Scanner;

public class TemperatureConverter {
    static double celsiusToFahrenheit(int c) {
        return c * 9 / 5 + 32;

    }

    static double celsiusToKelvin(int c) {
        return c + 273.15;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Celsius оруулна уу: ");
        int c = sc.nextInt();

        System.out.println("--- Хөрвүүлэлт ---");
        System.out.println("Celsius: " + c + "°C");
        System.out.println("Celsius: " + celsiusToFahrenheit(c) + "°F");
        System.out.println("Kelvin: " + celsiusToKelvin(c) + "K");

        sc.close();
    }
}
