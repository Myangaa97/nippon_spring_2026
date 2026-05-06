import java.util.Scanner;

public class J4B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saraa oruulna uu (1-12):");
        int day = scanner.nextInt();

        switch (day) {
            case 1, 2, 3: System.out.println("Winter"); break;
            case 4 , 5, 6: System.out.println("Spring"); break;
            case 7 , 8, 9: System.out.println("Summer"); break;
            case 10, 11, 12: System.out.println("Autumn"); break;
}
        scanner.close();
    }
}