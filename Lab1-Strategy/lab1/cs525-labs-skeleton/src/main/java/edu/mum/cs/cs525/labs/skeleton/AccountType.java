package edu.mum.cs.cs525.labs.skeleton;

public class AccountType {
    private String accountType;
    private Interestcalculator interestcalculator;

    public AccountType(String accountType, Interestcalculator interestcalculator) {
        this.accountType = accountType;
        this.interestcalculator = interestcalculator;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Interestcalculator getInterestcalculator() {
        return interestcalculator;
    }

    public void setInterestcalculator(Interestcalculator interestcalculator) {
        this.interestcalculator = interestcalculator;
    }
}
