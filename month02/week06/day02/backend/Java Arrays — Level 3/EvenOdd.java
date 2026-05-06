public class EvenOdd {
    public static void main(String[] args) {

        int[] nums = { 45, 12, 78, 3, 56, 29, 41, 67, 8, 34 };
        int evenCount = 0;
        int totalSum = 0;
        int evenSum = 0;
        for (int n : nums) {
            totalSum += n;
            if (n % 2 == 0) {
                evenSum += n;
                evenCount++;
            }
        }

        System.out.println("Even Numbers: " + evenCount);
        System.out.println("Odd Sum: " + (totalSum - evenSum));
    }
}
