import java.util.Scanner;

public class Receipt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me product name: ");
        String pro = scanner.nextLine();

        System.out.println("Give me product price: ");
        int price = scanner.nextInt();

        System.out.println("Give me units ");
        int unit = scanner.nextInt();

        int x = price * unit;

        System.out.println("Product Name: " + pro);
        System.out.println("Price: " + price);
        System.out.println("Units: " + unit);
        System.out.println("----------------------");
        System.out.println(pro + " * " + unit + " = " + x + "$");

        scanner.close();
    }
}
