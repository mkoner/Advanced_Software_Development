package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

public interface Command {
    void execute(TransactionPayload transactionPayload);
    void undo(TransactionPayload transactionPayload);
}
