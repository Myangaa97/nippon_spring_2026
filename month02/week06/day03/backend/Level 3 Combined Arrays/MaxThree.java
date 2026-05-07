public class MaxThree {
    public static void main(String[] args) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max1Index = -1;
        int max2Index = -1;
        int max3Index = -1;

        int[] nums = { 3, -45, 78, -16, 0, 62, 0, 26, 0, 37, 99, -2, 22, 78, 1, 32};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max3Index = max2Index;
                max2 = max1;
                max2Index = max1Index;
                max1 = nums[i];
                max1Index = i;
            }
            else if (nums[i] > max2) {
                max3 = max2;
                max3Index = max2Index;
                max2 = nums[i];
                max2Index = i;
            }
            else if (nums[i] > max3) {
                max3 = nums[i];
                max3Index = i;
            }
        }
        System.out.println("Max 1 Index: [" + max1Index + "] = " + max1);
        System.out.println("Max 2 Index: [" + max2Index + "] = " + max2);
        System.out.println("Max 3 Index: [" + max3Index + "] = " + max3);
    }
}
