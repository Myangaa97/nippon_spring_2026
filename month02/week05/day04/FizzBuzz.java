public class FizzBuzz {
    public static void main(String[] args) {
        int i = 1;
        while (i<51) {
            if (i%15==0){
                System.out.println("FizzBuzz");
            }
            else if (i%3==0){
                System.out.printf("Fizz");
            }
            else if (i%5==0){
                System.out.printf("Buzz");
            }
            else {
                System.out.printf(" "+ i + " ");
            }
            i++;
        }
        System.out.println( );
    }
}
