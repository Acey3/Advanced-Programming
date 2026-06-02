package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

/**
 * Interface for Transactions
 * Any class that defines a transaction is expected to implement this Interface
 */
public interface TransactionInterface {

    // Method to get the transaction amount
    double getAmount();

    // Method to get the transaction date
    Calendar getDate();

    // Method to get a unique identifier for the transaction
    String getTransactionID();

    // ADDED FOR QUESTION 1: Method to print a transaction receipt or details
    void printTransactionDetails();

    // ADDED FOR QUESTION 1 & 3: Method to apply transaction logic to an account balance
    void apply(BankAccount ba) throws InsufficientFundsException;
}