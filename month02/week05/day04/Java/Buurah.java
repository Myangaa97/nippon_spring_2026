public class Buurah {
    public static void main(String[] args) {
        int sum = 0;
        int i = 100;
        while(i>0) {
            sum = sum + i;
            i = i - 10;
            System.out.printf(i + " ");
        }
        System.out.println( );
        System.out.println("Нийлбэр: " + sum);
    }
}
