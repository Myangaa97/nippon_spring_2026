import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("5 too oruulna uu: ");
        
        int size = 5, sum = 0;
        int[] nums = new int[size];

        for (int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
            sum +=nums[i];
        }
        int dundaj = sum / size;
        System.out.println("Sum: " + sum);
        System.out.println("Dundaj: " + dundaj);

        sc.close();
    }
}
