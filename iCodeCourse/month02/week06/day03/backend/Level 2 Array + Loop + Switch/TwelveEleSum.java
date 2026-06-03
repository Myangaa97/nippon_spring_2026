public class TwelveEleSum {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        int[] nums = { 3, -45, 78, -16, 0, 62, 0, 26, 0, 37 };
        while (i < nums.length) {
            if (nums[i] % 3 == 0) {
                sum += nums[i];
            }
            i++;
        }
        System.out.println("Тооны нийлбэр: " + sum);
    }
}