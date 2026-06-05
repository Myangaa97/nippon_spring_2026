abstract class BankAccount {
    protected String owner;
    protected double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if(amount >0) balance += amount;
    }

    abstract void withdraw(double amount);
    abstract double monthlyFee();

    double getBalance() {
        return balance;
    }

    void applyMonthlyFee() {
        balance -= monthlyFee();
    }

    @Override
    public String toString() {
        return owner + " | " + getClass().getSimpleName() + " | Balance: " + balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String owner, double initialBalance, double miniBalance) {
        super(owner, initialBalance);
        this.miniBalance = miniBalance;
    }

    @Override
    void withdraw(double amount) {
        if(balance - amount < miniBalance) {
            throw new IllegalArgumentException("Would go below minimum balance");
        }
        balance§-= amount;
    }

    @Override
    double monthlyFee() {
        return 0;
    }
}

class CheckingAccount extends BankAccount {
    private int freeTransactions;
    private int transactionCount;
    public CheckingAccount(String owner, double initialBalance, int freeTransactions) {
        super(owner, initialBalance);
        this.freeTransactions = freeTransactions;
        this.transactionCount = 0;
    }

    @Override
    void withdraw(double amount) {
        if(transactionCount >= freeTransactions) {
            balance -= 500;
        }
        balance -= amount;
    }

    @Override
    double monthlyFee() {
        return 2000;
    }
}