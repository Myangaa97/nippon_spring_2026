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
            if (amount <= 0) {
                System.out.println("Error: буруу дүн");
            } else {
                balance += amount;
                transactionCount++;
                System.out
                        .println("Орлого : " + amount + "₮ | " + "Үлдэгдэл : " + (balance) + " | Данс: "
                                + accountNumber);
            }
        }

        boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Error: буруу дүн");
                return false;
            }
            if (amount > balance) {
                System.out.println(
                        "Үлдэгдэл хүрэлцэхгүй! Хүссэн: " + amount + "₮, Байгаа: " + balance);
                return false;
            }
            balance -= amount;
            transactionCount++;
            System.out.println("Зарлага: " + amount + "₮ | Үлдэгдэл: " + balance + " | Данс: "
                    + accountNumber);
            return true;
        }

        boolean transfer(BankAccount to, double amount) {
            if (withdraw(amount)) {
                to.deposit(amount);
                System.out.println("Шилжүүлэг: " + amount + "₮ [" + this.accountNumber + " -> "
                        + to.accountNumber + "]");
                return true;
            }
            return false;
        }

        void showSummary() {
            System.out.println("===== ДАНС ТАЙЛАН =====");
            System.out.println("Данс: " + accountNumber);
            System.out.println("Эзэмшигч: " + owner);
            System.out.println("Үлдэгдэл: " + balance);
            System.out.println("Гүйлгээ: " + transactionCount);
            System.out.println("========================");
        }

        double getBalance() {
            return balance;
        }

        static void showAllAccounts(BankAccount[] accounts) {
            double total = 0;
            System.out.println("--- Бүх Дансны Тайлан ---");
            for (BankAccount acc : accounts) {
                total += acc.balance;
                System.out.println(acc.accountNumber + " | " + acc.owner + " | " + acc.balance);
            }

            System.out.println("Нийт баланс: " + total);
        }

        static BankAccount richest(BankAccount[] accounts) {
            BankAccount rich = accounts[0];
            for (BankAccount acc : accounts) {
                if (acc.balance > rich.balance) {
                    rich = acc;
                }
            }
            return rich;
        }
    }

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("ACC-001", "Батаа", 1000000);
        BankAccount acc2 = new BankAccount("ACC-002", "Сарнай", 500000);
        BankAccount acc3 = new BankAccount("ACC-003", "Байгуул", 1400000);

        System.out.println("=== iCode Банкны Систем ===\n");
        System.out.println("--- Дансууд үүсгэгдлээ ---");
        System.out.println(acc1.owner + " (" + acc1.accountNumber + "): " + acc1.balance + "₮");
        System.out.println(acc2.owner + " (" + acc2.accountNumber + "): " + acc2.balance + "₮");
        System.out.println(acc3.owner + " (" + acc3.accountNumber + "): " + acc3.balance + "₮");

        System.out.println("\n--- Гүйлгээнүүд ---");
        acc1.deposit(200000);
        acc1.withdraw(300000);
        acc1.transfer(acc2, 150000);
        acc3.withdraw(5000000);

        BankAccount[] allAccounts = { acc1, acc2, acc3 };
        BankAccount.showAllAccounts(allAccounts);

        System.out.println("\n--- Хамгийн Их Үлдэгдэлтэй ---");
        BankAccount rich = BankAccount.richest(allAccounts);
        System.out.println(rich.owner + " (" + rich.accountNumber + ") : " + rich.balance);

        System.out.println("\n--- Дэлгэрэнгүй Тайлан ---");
        acc1.showSummary();
    }
}