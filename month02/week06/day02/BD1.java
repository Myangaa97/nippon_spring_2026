public class BD1 {
    public static void main(String[] args) {
        int[] nums = {5, 92, 78, 96, 70};
        System.out.println("Scores 2nd: " + nums[1]);
        System.out.println("Last Element: " + nums[nums.length - 1]);
        nums[1] = 88;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        nums[1] = nums[1] * 2;
        System.out.println("gar" + nums[1]);
            }
}