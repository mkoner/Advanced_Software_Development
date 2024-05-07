package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;

public class TransactionPayload {
    private String toAccount;
    private String fromAccount;
    private double amount;
    private String description;

    public TransactionPayload(String toAccount, String fromAccount, double amount, String description) {
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.amount = amount;
        this.description = description;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
