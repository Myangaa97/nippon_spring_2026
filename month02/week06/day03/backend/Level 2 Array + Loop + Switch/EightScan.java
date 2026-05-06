import java.util.Scanner;

public class EightScan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[8];
        System.out.println("8 too oruulna uu: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();

            if (nums[i] > 10) {
                System.out.println(nums[i]);
            }
        }

        sc.close();
    }
}
