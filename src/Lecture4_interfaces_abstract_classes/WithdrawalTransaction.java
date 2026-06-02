package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    private double amountNotWithdrawn =0;

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkWithdrawalAmount(int amt) {
      return amt >= 0;
    }


    // Method to reverse the transaction
    public boolean reverse(BankAccount ba) {
        double curr_balance=ba.getBalance();
        double restore_balance = curr_balance + getAmount();
        ba.setBalance(restore_balance);
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal TransactionID: " + getTransactionID() + "|Amount:$ " +getAmount());
    }

    /*
    Opportunity for assignment: implementing different form of withdrawal
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        if (ba.getBalance() < getAmount()) {

        throw new InsufficientFundsException("Insufficient Funds! Transaction declined.");

        }
        double new_balance = curr_balance - getAmount();
        ba.setBalance(new_balance);
    }

    public void apply (BankAccount ba, boolean allowPartial) {
        try {
            double curr_balance = ba.getBalance();
            double withdrawalAmount = getAmount();

            if (curr_balance > 0 && curr_balance < withdrawalAmount) {
                this.amountNotWithdrawn = withdrawalAmount - curr_balance;
                ba.setBalance(0);
                System.out.println("Partial withdrawal processed. Deficit remainder: $" + amountNotWithdrawn);
            } else {
                apply(ba);
                System.out.println("Standard withdrawal successfully processed.");
            }
        } catch (InsufficientFundsException e) {
            // Local exception catch blocks keep execution stack safe from unexpected system failure
            System.err.println("Transaction Blocked locally: " + e.getMessage());

        } finally {
            // Mandatory block confirming transaction state evaluations are structurally over
            System.out.println("Transaction pipeline process completed.");
        }
    }
            public double getAmountNotWithdrawn() {
             return amountNotWithdrawn;
        }

         /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */


}





