package edu.mum.cs.cs525.labs.skeleton;

public interface AccountSubject {
    void register(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(String message);
}
