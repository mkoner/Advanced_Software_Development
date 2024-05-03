package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;

public abstract class InterestPromotionDecorator extends Account {
    private Account account;
    public InterestPromotionDecorator(Account account) {
        this.account = account;
    }
    public abstract void addInterest();

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
