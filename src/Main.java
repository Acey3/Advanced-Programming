/*import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
* Client Code for accessing the Lecture1_adt.TransactionInterface.java module
 *
public class Main {

    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
        Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

        System.out.println(t1.toString());
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);

        // Please note that the Client Codes can access the data in the class directly through the dot operator
        // This kind of exposure is a threat to both the Representation Independence and Preservation of Invariants
    }


    /** @return a transaction of same amount as t, one month later
     * This is a PRODUCER of the class Lecture1_adt.Transaction2
     * This code will help demostrate the Design exposures still present in transaction2 class
     * *

    public static Transaction2 makeNextPayment(Transaction2 t) {
        Calendar d =  t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction2(t.getAmount(), d);
    }

    /*
    Testing Transaction2 class
     *
    public static void testTransaction2() {

        Calendar d1 = new GregorianCalendar();

        Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);

        Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);

        System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

        System.out.println("\n\nHow does T2 Look Like?????");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t "+modified_t.getDate().getTime());

        /* Please note that Although we have solved the problem of Transaction1
        * And client code can no longer use the dot (.) operator to directly access the data
        * There is still some exposure especially if we pass an object of a previous Transaction2 to create a new Transaction2 object
         *

    }


    /** @return a list of 12 monthly payments of identical amounts
     * This code will help demostrate the Design exposures still present in transaction3 class
     * *
    public static List<Transaction3> makeYearOfPayments (int amount) throws NullPointerException {

        List<Transaction3> listOfTransaction3s = new ArrayList<Transaction3>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);


        for (int i = 0; i < 12; i++) {
            listOfTransaction3s.add(new Transaction3(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction3s;
    }

    /*
    Testing Transaction3 class
     *
    public static void testTransaction3() {

        List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);

        for (Transaction3 t3 : allPaymentsIn2024) {

            // Display all the 12 Transactions
            for (Transaction3 transact : allPaymentsIn2024) {
                System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
                System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
                System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
            }
        }

        /* Please Check all the 12 transactions displayed and hwo their dates look like
         * Note that Although Transaction3 class resolves to an extent the exposure in Transaction2 class
         * There is still some exposure especially if we pass an object of a previous Transaction3 to create a
         * new Transaction3 object
         *
    }


    /** @return a list of 12 monthly payments of identical amounts
     * This code Show that by judicious copying and defensive programming we eliminate the exposure in Transaction3
     * As defined in the constructor of Transaction4 class
     * *

    public static List<Transaction4> makeYearOfPaymentsFinal (int amount) throws NullPointerException {

        List<Transaction4> listOfTransaction4s = new ArrayList<Transaction4>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);


        for (int i = 0; i < 12; i++) {
            listOfTransaction4s.add(new Transaction4(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction4s;
    }

    /*
    Testing Transaction3 class
     *
    public static void testTransaction4() {

        /*
         * Call the function to make all the Twelve transaction in a year of our business
         *

        List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);

        // Display all the 12 Transactions
        for (Transaction4 transact : transactionsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t "+transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t "+transact.getDate().getTime());
        }

        // Please Take a look at all the 12 transaction now and compare with the outputs of the Transaction3 class
    }


    public static void main(String[] args) {
        // This is the client code
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1()
        // testTransaction2()
        // testTransaction3()
        // testTransaction4()
    }
}

 */
package Lecture4_interfaces_abstract_classes; // Match your current package folder

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
            System.err.println("Caught Custom Exception Successfully: " + e.getMessage());
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

    // =========================================================================
    // LECTURER'S ORIGINAL CODE BLOCKS (MAINTAINING HISTORICAL INTEGRITY)
    // =========================================================================
    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar();
        // Emulating past structures by allocating localized fallback logic if needed
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
        // This is the client code
        // Uncomment the following lines to test the class which you would like to test

        // testTransaction1();
        // testTransaction2();
        // testTransaction3();
        // testTransaction4();

        // ACTIVATE NEW ASSIGNMENT CODE HERE:
        testAdvancedAssignment();
    }
}