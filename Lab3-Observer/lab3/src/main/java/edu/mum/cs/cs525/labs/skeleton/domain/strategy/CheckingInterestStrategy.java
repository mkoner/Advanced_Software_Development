package edu.mum.cs.cs525.labs.skeleton.domain.strategy;

public class CheckingInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        if(balance<1000)
            return balance*0.015;
        return balance*0.025;
    }
}
