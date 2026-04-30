import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" n too oruul: ");
        int n = sc.nextInt();

        for (int a=1; a<=n; a++){
            for(int b=1; b<=a; b++) {
                System.out.printf("* ");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}
