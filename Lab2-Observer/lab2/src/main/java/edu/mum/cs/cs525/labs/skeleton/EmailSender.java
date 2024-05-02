package edu.mum.cs.cs525.labs.skeleton;

public class EmailSender implements Observer{
    @Override
    public void update(String message) {
        if(message.contains("Created"))
            System.out.println("Email: " + message);
    }
}
