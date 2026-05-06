public class Test {
    public static void main(String[] args) {

        int[] nums = { 15, 45, 47, 84, 58, 27 };

        System.out.printf("Top 3 Max: ");
        int max = nums[0];
        int max2 = nums[0];
        int max3 = nums[0];
        int maxIndex = 0;
        int maxIndex2 = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (i == maxIndex) {
                continue;
            }
            if (nums[i] > max2) {
                max2 = nums[i];
                maxIndex2 = i;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (i == maxIndex || i == maxIndex2) {
                continue;
            }
            if (nums[i] > max3) {

                max3 = nums[i];
            }
        }

        System.out.printf(max + " " + max2 + " " + max3);
    }
}
