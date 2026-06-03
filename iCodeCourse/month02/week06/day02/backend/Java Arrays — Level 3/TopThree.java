public class TopThree {
    public static void main(String[] args) {

        int[] nums = { 15, 45, 47, 84, 1, 27 };
        int count = 3;

        System.out.printf("Top 3 Max: ");
        while (count != 0) {
            int max = nums[0];
            int maxIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            System.out.printf(max + " ");
            nums[maxIndex] = 0;
            count--;
        }
    }
}
