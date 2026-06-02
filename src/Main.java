package Lecture4_interfaces_abstract_classes; // 1. UPDATED PACKAGE

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

/*
 * Client Code for accessing the Lecture4_interfaces_abstract_classes modules
 */
public class Main {

    // =========================================================================
    // NEW: TEST METHOD FOR ASSIGNMENT ONE (QUESTIONS 1, 2, 3 & 4)
    // =========================================================================
    public static void testAdvancedAssignment() {
        System.out.println("=== STARTING ADVANCED PROGRAMMING ASSIGNMENT ONE TESTS ===");

        Calendar now = new GregorianCalendar();

        // 1. Initialize account with $500 as requested in client specifications
        BankAccount myAccount = new BankAccount(500.0);
        System.out.println("Initial Bank Account Balance: $" + myAccount.getBalance());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::\n");

        // 2. Testing Question 1 & 4: Subtype mapping to Base type (Type Casting / Polymorphism)
        System.out.println("--- Testing Deposit via Base Type Reference (Polymorphism) ---");
        DepositTransaction deposit = new DepositTransaction(200, now);

        try {
            // Type casting subtype object to the base type object
            BaseTransaction baseRefDeposit = (BaseTransaction) deposit;

            // Testing the apply() method on the base class reference
            baseRefDeposit.apply(myAccount);
            baseRefDeposit.printTransactionDetails();
            System.out.println("Account Balance after Deposit: $" + myAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::\n");

        // 3. Testing Question 3 & 4: Exception Handling with throws and try...catch block
        System.out.println("--- Testing Withdrawal Exception Triggering ---");
        WithdrawalTransaction expensiveWithdrawal = new WithdrawalTransaction(1000, now);

        try {
            // Type casting to base reference again to demonstrate Late Binding polymorphism
            BaseTransaction baseRefWithdrawal = (BaseTransaction) expensiveWithdrawal;

            System.out.println("Attempting to withdraw $1000 from a $" + myAccount.getBalance() + " account...");
            baseRefWithdrawal.apply(myAccount); // This will throw our custom exception!

        } catch (InsufficientFundsException e) {
            // Fulfilling exception catching design requirements
            System.out.println("\nCaught Custom Exception Successfully: " + e.getMessage());
        }
        System.out.println("Account Balance remains: $" + myAccount.getBalance());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::\n");

        // 4. Testing Question 3: Overloaded apply() method tracking unfulfilled balances
        System.out.println("--- Testing Overloaded Partial Withdrawal (Try-Catch-Finally) ---");
        WithdrawalTransaction partialWithdrawal = new WithdrawalTransaction(900, now);

        System.out.println("Attempting partial withdrawal of $900...");
        // This execution runs the internal try-catch-finally block safely draining account to 0
        partialWithdrawal.apply(myAccount, true);

        System.out.println("Final Account Balance: $" + myAccount.getBalance());
        System.out.println("Deficit Remainder logged inside object: $" + partialWithdrawal.getAmountNotWithdrawn());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::\n");

        // 5. Testing Question 2: Reversing a Withdrawal Transaction
        System.out.println("--- Testing Reversal Logic ---");
        myAccount.setBalance(300.0); // Reset balance to $300 for reversal testing
        System.out.println("Reset balance for simulation: $" + myAccount.getBalance());

        WithdrawalTransaction standardWithdrawal = new WithdrawalTransaction(100, now);
        try {
            standardWithdrawal.apply(myAccount);
            System.out.println("Withdrew $100. Current Balance: $" + myAccount.getBalance());

            System.out.println("Triggering reverse() to undo transaction...");
            standardWithdrawal.reverse(myAccount); // Restores balance state

            System.out.println("Restored Bank Account Balance: $" + myAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("=== ADVANCED PROGRAMMING ASSIGNMENT ONE TESTS COMPLETE ===\n");
    }


    public static void testTransaction1() {
        System.out.println("Lecture1 Legacy Simulator stub running.");
    }

    public static void testTransaction2() {
        System.out.println("Lecture2 Legacy Simulator stub running.");
    }

    public static void testTransaction3() {
        System.out.println("Lecture3 Legacy Simulator stub running.");
    }

    public static void testTransaction4() {
        System.out.println("Lecture4 Legacy Simulator stub running.");
    }

    public static void main(String[] args) {
        // testTransaction1();
        // testTransaction2();
        // testTransaction3();
        // testTransaction4();

        // 2. ACTIVATING THE NEW ASSIGNMENT ENTRY POINT
        testAdvancedAssignment();
    }
}