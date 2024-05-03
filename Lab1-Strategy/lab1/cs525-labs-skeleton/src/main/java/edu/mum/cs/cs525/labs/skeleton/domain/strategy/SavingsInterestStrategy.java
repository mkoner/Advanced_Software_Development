package edu.mum.cs.cs525.labs.skeleton.domain.strategy;

public class SavingsInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        if(balance<1000)
            return balance*0.01;
        if(balance<5000)
            return balance*0.02;
        return balance*0.04;
    }
}
