package edu.mum.cs.cs525.labs.skeleton;

public class CheckingInterestCalculator implements Interestcalculator{
    @Override
    public double calculateInterest(double balance) {
        if(balance<1000)
            return balance*0.015;
        return balance*0.025;
    }
}
