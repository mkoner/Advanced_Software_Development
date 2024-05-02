package edu.mum.cs.cs525.labs.skeleton;

public class SMSSender implements Observer{
    @Override
    public void update(String message) {
        System.out.println("SMS: " + message);
    }
}
