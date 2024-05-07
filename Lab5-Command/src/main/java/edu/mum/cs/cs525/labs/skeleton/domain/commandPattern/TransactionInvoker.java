package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

public class TransactionInvoker {
    Command transaction;
    public void execute(TransactionPayload transactionPayload) {
        transaction.execute(transactionPayload);
    }
    public void undo(TransactionPayload transactionPayload) {
        transaction.undo(transactionPayload);
    }

    public void setTransaction(Command transaction) {
        this.transaction = transaction;
    }
}
