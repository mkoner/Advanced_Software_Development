package edu.mum.cs.cs525.labs.skeleton.domain;

import edu.mum.cs.cs525.labs.skeleton.domain.strategy.InterestStrategy;

public class AccountType {
    private String accountType;
    private InterestStrategy interestStrategy;

    public AccountType(String accountType, InterestStrategy interestStrategy) {
        this.accountType = accountType;
        this.interestStrategy = interestStrategy;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public InterestStrategy getInterestcalculator() {
        return interestStrategy;
    }

    public void setInterestcalculator(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }
}
