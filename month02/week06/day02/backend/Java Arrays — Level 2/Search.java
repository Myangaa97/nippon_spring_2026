public class Search {
    public static void main(String[] args) {
        int target = 42;
        boolean found = false;
        int [] nums = {23, 45, 42, 12, 67, 34};
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == target) {
                System.out.println("Олдсон: index " + i); 
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Олдсонгүй");
        }
    }
}
