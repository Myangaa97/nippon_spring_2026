public class EvenIndex {
    public static void main(String[] args) {
        int[] nums = { 3, 45, 78, 16, 11, 62, 91, 26 };
        for (int i = 0; i < nums.length; i = i + 2) {
            System.out.println(nums[i] + " ");
        }
    }
}
