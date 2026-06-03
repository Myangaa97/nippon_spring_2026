public class AboveAverage {
    public static void main(String[] args) {

        int sum = 0;
        float average;
        int[] nums = { 15, 45, 47, 84, 1, 27 };
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        average = sum / nums.length;
        System.out.println("Average: " + average);

        System.out.print("Above Average: ");
        for (int n : nums) {
            if (n > average)
                System.out.print(n + " ");
        }
    }
}