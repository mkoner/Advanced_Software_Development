package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;

public class P3 extends InterestPromotionDecorator{
    public P3(Account account) {
        super(account);
    }

    @Override
    public void addInterest() {
        double balance = getAccount().getBalance();
        AccountEntry entry = new AccountEntry(balance*0.03, "interest from decorator P3", "", "");
        getAccount().addEntry(entry);
        System.out.println(getAccount().getAccountNumber());
    }
}
