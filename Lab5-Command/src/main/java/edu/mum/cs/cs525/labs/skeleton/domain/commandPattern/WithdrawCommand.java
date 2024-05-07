package edu.mum.cs.cs525.labs.skeleton.domain.commandPattern;

import edu.mum.cs.cs525.labs.skeleton.service.AccountService;

public class WithdrawCommand implements Command{
    private AccountService accountService;

    public WithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }
    @Override
    public void execute(TransactionPayload transactionPayload) {
        accountService.withdraw(transactionPayload.getToAccount(),
                transactionPayload.getAmount());
    }

    @Override
    public void undo(String accountNumber) {
        accountService.undoLastTransaction(accountNumber);
    }
}
