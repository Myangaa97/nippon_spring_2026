import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        System.out.println("First product name: ");
        String stName = scanner.next();
        System.out.println("First product price ");
        int stPrice = scanner.nextInt();
        System.out.println("First product unit ");
        int stUnit = scanner.nextInt();

        System.out.println("Second product name: ");
        String ndName = scanner.next();
        System.out.println("Second product price ");
        int ndPrice = scanner.nextInt();
        System.out.println("Second product unit ");
        int ndUnit = scanner.nextInt();

        System.out.println("Third product name: ");
        String rdName = scanner.next();
        System.out.println("Third product price ");
        int rdPrice = scanner.nextInt();
        System.out.println("Third product unit ");
        int rdUnit = scanner.nextInt();

        int stSum = stPrice * stUnit;
        int ndSum = ndPrice * ndUnit;
        int rdSum = rdPrice * rdUnit;
        int sum = stSum + ndSum + rdSum;
        int no = (sum * 10) / 100;
        int nosum = no + sum;

        System.out.println("=== ДЭЛГҮҮР ===");
        System.out.println("1-р бараа нэр:      " + stName);
        System.out.println("1-р бараа үнэ (₮):  " + stPrice);
        System.out.println("1-р бараа тоо:      " + stUnit);
        System.out.println("");

        System.out.println("2-р бараа нэр:      " + ndName);
        System.out.println("2-р бараа үнэ (₮):  " + ndPrice);
        System.out.println("2-р бараа тоо:      " + ndUnit);
        System.out.println("");

        System.out.println("3-р бараа нэр:       " + rdName);
        System.out.println("3-р бараа үнэ (₮):   " + rdPrice);
        System.out.println("3-р бараа тоо:       " + rdUnit);
        System.out.println("");

        System.out.println("==============================");
        System.out.println(stName + " * " + stUnit + " =    " + stSum);
        System.out.println(ndName + " * " + ndUnit + " =    " + ndSum);
        System.out.println(rdName + " * " + rdUnit + " =    " + rdSum);
        System.out.println("------------------------------");
        System.out.println("Total Price                = " + sum);
        System.out.println("НӨАТ (10%)                 =" + no);
        System.out.println("Нийт (НӨАТ-тай)            = " + nosum);
        System.out.println("==============================");


        scanner.close();
    }
    
}