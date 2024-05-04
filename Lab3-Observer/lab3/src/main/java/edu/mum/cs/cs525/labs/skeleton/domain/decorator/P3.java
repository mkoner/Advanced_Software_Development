package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;

public class P3 extends InterestPromotionDecorator{
    public P3(Account account) {
        this.account = account;
    }

    @Override
    public void addInterest() {
        double balance = account.getBalance();
        AccountEntry entry = new AccountEntry(balance*0.03, "interest from P3", "", "");
        account.addEntry(entry);
        System.out.println("Interest added to account " + account.getAccountNumber());
    }
}
