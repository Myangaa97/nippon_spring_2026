import java.util.Scanner;

public class ArrayPalin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Хэдэн тоо оруулах вэ? ");
        int count = sc.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < nums.length; i++) {
            System.out.print((i + 1) + " дахь тоо: ");
            nums[i] = sc.nextInt();
        }

        int sum = 0;
        double average = 0;
        int evenCount = 0;
        int evenSum = 0;
        int max = nums[0];
        int min = Integer.MAX_VALUE;

        System.out.println("========== СТАТИСТИК ==========");
        System.out.printf("Өгөгдөл: ");
        for (int n : nums) {

            sum += n;
            average = sum / count;
            System.out.printf(n + "  ");
            if (n % 2 == 0) {
                evenCount++;
                evenSum += n;
            }

            if (n > max) {
                max = n;
            } else if (n < min) {
                min = n;
            }
        }
        System.out.println();
        System.out.println("Нийлбэр: " + sum);
        System.out.println("Дундаж: " + average);
        System.out.println("Хамгийн их: " + max);
        System.out.println("Хамгийн бага: " + min);
        System.out.println("Тэгш тоо: " + evenCount);
        System.out.println("Сондгой тооны нийлбэр: " + (sum - evenSum));
        System.out.printf("Эрэмбэлсэн: ");

        while (count != 0) {
            int min2 = nums[0];
            int minIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min2) {
                    min2 = nums[i];
                    minIndex = i;
                }
            }

            System.out.printf(min2 + " ");
            nums[minIndex] = Integer.MAX_VALUE;
            count--;
        }

        System.out.println();
        System.out.print("Дунджаас дээш: ");
        for (int n : nums) {
            if (n > average)
                System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("===============================");

        System.out.println();
        sc.close();
    }
}
