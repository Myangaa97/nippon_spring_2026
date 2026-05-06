public class Reverse {
    public static void main(String[] args) {

        int[] nums = { 45, 12, 78, 3, 56, 29, 41, 67, 8, 34 };
        System.out.print("Reverse: ");
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
    }
}
