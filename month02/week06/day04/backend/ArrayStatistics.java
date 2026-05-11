import java.util.Scanner;

public class ArrayStatistics {
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
        int evenCount = 0;
        int evenSum = 0;

        int max = nums[0];
        int min = nums[0];

        for (int n : nums) {

            sum += n;

            if (n % 2 == 0) {
                evenCount++;
                evenSum += n;
            }

            if (n > max) {
                max = n;
            }

            if (n < min) {
                min = n;
            }
        }

        double average = (double) sum / nums.length;

        System.out.println("\n========== СТАТИСТИК ==========");

        System.out.print("Өгөгдөл: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("Нийлбэр: " + sum);
        System.out.println("Дундаж: " + average);
        System.out.println("Хамгийн их: " + max);
        System.out.println("Хамгийн бага: " + min);
        System.out.println("Тэгш тоо: " + evenCount);
        System.out.println("Сондгой тооны нийлбэр: " + (sum - evenSum));

        int[] sorted = nums.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i] > sorted[j]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }

        System.out.print("Эрэмбэлсэн: ");

        for (int n : sorted) {
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.print("Дунджаас дээш: ");

        for (int n : nums) {
            if (n > average) {
                System.out.print(n + " ");
            }
        }

        System.out.println();
        System.out.println("===============================");

        sc.close();
    }
}