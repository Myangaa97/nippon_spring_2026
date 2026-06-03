public class TenEle {
    public static void main(String[] args) {
        int[] nums = { 3, -45, 78, -16, 0, 62, 0, 26, 0, 37 };

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int n : nums) {
            if (n > 0) {
                positiveCount++;
            } else if (n < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Эерэг тооны тоо: " + positiveCount);
        System.out.println("Сөрөг тооны тоо: " + negativeCount);
        System.out.println("Тэгийн тоо: " + zeroCount);
    }
}