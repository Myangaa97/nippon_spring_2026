import java.util.Scanner;

public class MyProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("give me name");
        String name = scanner.nextLine();

        System.out.println("Give me your age");
        int age = scanner.nextInt();

        System.out.println("Gime me fav food");
        String food = scanner.next();


        System.out.println("My name is " + name + ".");
        System.out.println("I'am " + age + "years old.");
        System.out.println("My favourite food is " + food + ".");

        scanner.close();
    }
}
