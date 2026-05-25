import java.util.Scanner;

public class BankSystem {
    static class BankAccount {
        String accountNumber;
        String owner;
        double balance;
        int transactionCount;

        BankAccount(String accountNumber, String owner, double initialBalance) {
            this.accountNumber = accountNumber;
            this.owner = owner;
            this.balance = initialBalance;
        }

        void deposit(double amount) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Enter Deposit : ");
            amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.printf("Error");
            } else {
                transactionCount++;
                System.out.printf("Орлого : " + this.amount + " | " + "Үлдэгдэл : " + (balance + amount));
            }
        }

    }

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("ACC-001", "Батаа", 1000000);
        BankAccount acc2 = new BankAccount("ACC-002", "Сарнай", 500000);
        BankAccount acc3 = new BankAccount("ACC-003", "Байгуул", 1400000);

        System.out.println("=== iCode Банкны Систем ===\n");
        System.out.println("--- Дансууд үүсгэгдлээ ---");
        acc1.deposit(20000);
        acc1.tr

    }
}