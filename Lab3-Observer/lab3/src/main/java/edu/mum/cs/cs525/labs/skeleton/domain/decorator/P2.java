package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;

public class P2 extends InterestPromotionDecorator{
    public P2(Account account) {
        this.account = account;
    }

    @Override
    public void addInterest() {
        double balance = account.getBalance();
        AccountEntry entry = new AccountEntry(balance*0.02, "interest from P2", "", "");
        account.addEntry(entry);
    }
}
