import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Хэдэн тоо оруулах вэ? ");
        int count = sc.nextInt();

        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) {
            System.out.print((i + 1) + " дахь тоо: ");
            nums[i] = sc.nextInt();
        }

        boolean isPalindrome = true;
        int i = 0;
        while (i < nums.length / 2) {
            if (nums[i] != nums[nums.length - 1 - i]) {
                isPalindrome = false;
                break;
            } else {
                i++;
            }
        }
        if (isPalindrome == false) {
            System.out.println("Not Palindrome");
        } else {
            System.out.println("Palindrome");
        }
        sc.close();
    }
}
