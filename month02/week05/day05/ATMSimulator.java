import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Тавтай морил! ATM ===");
        System.out.println("PIN оруулна уу: ");
        int balance = 1000000;
        int pass = 1234;
        int pin, select = 0;
        int attemps = 3;
        int logged = 0;

        while (attemps > 0) {
            pin = sc.nextInt();

            if (pass == pin) {
                System.out.println("Нэвтрэлт амжилттай!");
                attemps = 0;
                logged = 1;

            }
            
            else {
                attemps --;
            
            if (attemps > 0) {
                    
                    System.out.println("PIN буруу. " + attemps + " оролдлого үлдлээ");
                } else {
                    System.out.println("Оролдлого дууслаа. Карт түгжигдлээ.");
                }
            }
        }

        while (logged == 1 && select != 4) {
        System.out.println("╔═══════════════════╗");
        System.out.println("║   Үйлдэл сонгоно  ║");
        System.out.println("║ 1. Үлдэгдэл       ║");
        System.out.println("║ 2. Мөнгө авах     ║");
        System.out.println("║ 3. Мөнгө хийх     ║");
        System.out.println("║ 4. Гарах          ║");
        System.out.println("╚═══════════════════╝");
        System.out.println( );

        select = sc.nextInt();
            switch (select) {
                case 1: 
                    System.out.printf(balance + "₮");
                    break;  
                case 2:
                    System.out.println("Авах дүн оруулна уу : ");
                    int deposit = sc.nextInt();
                        if (deposit < 500000) {
                            balance = balance - deposit;
                            System.out.println(deposit + "₮ олгов.");
                        } else {
                            System.out.println("Хязгаар хэтэрлээ (500,000₮)");
                        } break;

                case 3:
                    System.out.println("Хийх дүн оруулна уу : ");
                    int withdraw = sc.nextInt();
                        if (withdraw > 0) {
                            balance = balance + withdraw;
                        } else {
                            System.out.println("Буруу дүн");
                        } break;

                case 4:
                    System.out.println("Баярлалаа! Аюулгүй яваарай."); break;
                            
            }

            if (select != 4) {
                System.out.printf("Дахин үйлдэл хийх үү? (1-Тийм / 4-Гарах): ");
                select = sc.nextInt(); 
            }
            System.out.println("Баярлалаа! Аюулгүй яваарай.");
        }
        
        sc.close();
    }
       
}