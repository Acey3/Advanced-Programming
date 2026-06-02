package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(int amt){
        if (amt < 0){
           return false;
        }
        else{
            return  true;
        }
    }

    // Method to print a transaction receipt or details
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: "+this.toString());
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
    }
}
