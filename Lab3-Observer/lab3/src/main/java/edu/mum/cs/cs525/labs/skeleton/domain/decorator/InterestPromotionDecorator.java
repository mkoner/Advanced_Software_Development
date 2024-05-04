package edu.mum.cs.cs525.labs.skeleton.domain.decorator;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;

public abstract class InterestPromotionDecorator extends Account {
    Account account;
    public abstract void addInterest();
}
