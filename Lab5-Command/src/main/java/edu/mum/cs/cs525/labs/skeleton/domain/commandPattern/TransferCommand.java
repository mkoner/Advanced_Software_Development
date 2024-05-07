package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

public class TransferCommand implements Command {
    private AccountService accountService;
    public TransferCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(TransactionPayload transactionPayload) {
        accountService.transferFunds(transactionPayload.getFromAccount(),
                transactionPayload.getToAccount(), transactionPayload.getAmount(),
                transactionPayload.getDescription());
    }

    @Override
    public void undo(String accountNumber) {
        accountService.undoLastTransaction(accountNumber);
    }
}
