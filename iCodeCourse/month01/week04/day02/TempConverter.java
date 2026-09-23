import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Celsius: ");
        float temp = scanner.nextFloat();

        float x = temp * 9 / 5 + 32;
        char ch = (char) 176;
        System.out.println(temp + "" + ch + "C = " + x + ch + "F");

        scanner.close();
    }
}
