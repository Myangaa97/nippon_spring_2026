package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // --- SavingsAccount тестүүд ---

    @Test
    void testSavingsDeposit() {
        SavingsAccount acc = new SavingsAccount("Bataa", 100_000, 50_000);
        acc.deposit(30_000);
        assertEquals(130_000, acc.getBalance(), 0.001);
    }

    @Test
    void testSavingsWithdraw() {
        SavingsAccount acc = new SavingsAccount("Bataa", 100_000, 50_000);
        acc.withdraw(40_000);
        assertEquals(60_000, acc.getBalance(), 0.001);
    }

    @Test
    void testSavingsBelowMinimum() {
        SavingsAccount acc = new SavingsAccount("Bataa", 100_000, 50_000);
        // withdrawing 60,000 would leave 40,000 which is below min 50,000
        assertThrows(IllegalStateException.class, () -> acc.withdraw(60_000));
    }

    @Test
    void testSavingsNoMonthlyFee() {
        SavingsAccount acc = new SavingsAccount("Bataa", 100_000, 50_000);
        assertEquals(0, acc.monthlyFee(), 0.001);
    }

    // --- CheckingAccount тестүүд ---

    @Test
    void testCheckingWithdrawFree() {
        CheckingAccount acc = new CheckingAccount("Sarnai", 200_000, 3);
        acc.withdraw(10_000); // 1st transaction — free
        assertEquals(190_000, acc.getBalance(), 0.001);
    }

    @Test
    void testCheckingWithdrawWithFee() {
        CheckingAccount acc = new CheckingAccount("Sarnai", 200_000, 1);
        acc.withdraw(10_000); // 1st — free
        acc.withdraw(10_000); // 2nd — 500 fee applied
        // 200_000 - 10_000 - 500 - 10_000 = 179_500
        assertEquals(179_500, acc.getBalance(), 0.001);
    }

    @Test
    void testCheckingInsufficientFunds() {
        CheckingAccount acc = new CheckingAccount("Sarnai", 5000, 3);
        assertThrows(IllegalStateException.class, () -> acc.withdraw(10000));
    }

    @Test
    void testCheckingMonthlyFee() {
        CheckingAccount acc = new CheckingAccount("Sarnai", 200000, 3);
        assertEquals(2000, acc.monthlyFee(), 0.001);
    }

    @Test
    void testApplyMonthlyFee() {
        CheckingAccount acc = new CheckingAccount("Sarnai", 200000, 3);
        acc.applyMonthlyFee();
        assertEquals(198000, acc.getBalance(), 0.001);
    }

    // --- Полиморфизм тест ---
    @Test
    void testPolymorphicDeposit() {
        BankAccount[] accounts = {
                new SavingsAccount("A", 100000, 50_000),
                new CheckingAccount("B", 100000, 3)
        };
        for (BankAccount acc : accounts) {
            acc.deposit(10000);
            assertEquals(110000, acc.getBalance(), 0.001);
        }
    }
}