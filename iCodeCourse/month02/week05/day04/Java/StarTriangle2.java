import java.util.Scanner;

public class StarTriangle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" n too oruul: ");
        int n = sc.nextInt();

        for (int a=1; a<=n; a++){
            for(int b=a; b<=n; b++) {
                System.out.printf("* ");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}
