import java.util.Scanner;

public class ValidInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1-10 хооронд тоо оруулна уу: ");
        int num = sc.nextInt();
        
        System.out.println("Зөв оруулсан тоо: " + num);
        sc.close();
    }
}
