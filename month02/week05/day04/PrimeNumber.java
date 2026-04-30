import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n too oruul: ");
        int n = sc.nextInt();
        

        for (int a=1; a<=n; a++){
            int sum=1;
            for(int b=1; b<a; b++) {
                if (a%b==0)
                    sum++;
            }
            if(sum==2) {
            System.out.println(a);
            }
        }
        sc.close();
    }
}
