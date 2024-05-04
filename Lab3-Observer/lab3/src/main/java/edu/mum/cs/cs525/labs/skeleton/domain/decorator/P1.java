package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;

public class P1 extends InterestPromotionDecorator{
    public P1(Account account) {
        this.account = account;
    }

    @Override
    public void addInterest() {
        double balance = account.getBalance();
        AccountEntry entry = new AccountEntry(balance*0.01, "interest from P1", "", "");
        account.addEntry(entry);
    }
}
