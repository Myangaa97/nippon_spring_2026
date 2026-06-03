public class Tegsh {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("Тэгш тоонууд: ");
        for (int i=1; i<51 ; i++) {
            if (i % 2 == 0) {
                System.out.printf(i + " ");
                sum = sum + i;
            }
        }
        System.out.println( );

        System.out.println("Niilber: " + sum);
    }
}
