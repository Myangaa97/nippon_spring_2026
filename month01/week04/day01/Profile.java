import java.util.Scanner;

public class Profile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("give me name");
        String name = scanner.nextLine();

        System.out.println("Give me your age");
        int age = scanner.nextInt();

        System.out.println("Gime me birthplace");
        String city = scanner.next();


        System.out.println("=============================");
        System.out.println("Name : "+name);
        System.out.println("Age  : "+age);
        System.out.println("City : "+city);
        System.out.println("=============================");

        scanner.close();
    }
}
