package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

public class TransactionInvoker {
    Command transaction;
    public void execute(TransactionPayload transactionPayload) {
        transaction.execute(transactionPayload);
    }
    public void undo(String accountNumber) {
        transaction.undo(accountNumber);
    }

    public void setTransaction(Command transaction) {
        this.transaction = transaction;
    }
}
