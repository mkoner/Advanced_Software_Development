package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

public class DepositCommand implements Command {
    private AccountService accountService;

    public DepositCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public void execute(TransactionPayload transactionPayload) {
        accountService.deposit(transactionPayload.getToAccount(),
                transactionPayload.getAmount());
    }

    @Override
    public void undo(TransactionPayload transactionPayload) {
        accountService.withdraw(transactionPayload.getToAccount(),
                transactionPayload.getAmount());
    }
}
