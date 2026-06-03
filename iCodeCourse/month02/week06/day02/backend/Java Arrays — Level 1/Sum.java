public class Sum {
    public static void main(String[] args) {
        int sum = 0;

        int [] nums = {23, 45, 12, 67, 34};
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println("Sum: " + sum);
    }
}