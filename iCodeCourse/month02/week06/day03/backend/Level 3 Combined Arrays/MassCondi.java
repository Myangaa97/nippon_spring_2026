public class MassCondi {
    public static void main(String[] args) {

        int[] nums = { 3, -45, 78, -16, 0, 62, 0, 26, 0, 37, 99, -2, 22, 78, 1, 32, 8};
        
        System.out.println("Even < 10 numbers: ");
        for (int n:nums) {
            if (n % 2 == 0 && n > 10) {
                System.out.printf(n + "   ");
            }
        }

        System.out.println();
        System.out.println("Odd < 20 numbers: ");
        for (int n:nums) {
            if (n % 2 != 0 && n < 20) {
                System.out.printf(n + "   ");
            }
        }

        System.out.println();
        System.out.println("Odd < 20, Even < 10 numbers: ");
        for (int n:nums) {
            if ((n % 2 == 0 && n > 10)||(n % 2 != 0 && n < 20)) {
                System.out.printf(n + "   ");
            }
        }
        System.out.println( );
    }
}
