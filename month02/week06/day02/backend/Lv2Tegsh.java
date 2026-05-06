public class Lv2Tegsh {
    public static void main(String[] args) {
        int[] data = {3, 8, 1, 6, 12, 7, 4, 9, 2, 5};
        int evenCount = 0;

        for (int n : data) {
            if (n % 2 == 0) evenCount++;
        }

        System.out.println("Тэгш тоонуудын тоо: " + evenCount);

        System.out.print("Тэгш тоонууд: ");
        for (int n : data) {
            if (n % 2 == 0) System.out.print(n + " ");
        }
    }
}
