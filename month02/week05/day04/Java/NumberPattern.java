public class NumberPattern {
    public static void main(String[] args) {
        for (int a=1; a<=5; a++){
            for(int b=1; b<=a; b++) {
                System.out.printf(b + " ");
            }
            System.out.println(" ");
        }
    }
}
