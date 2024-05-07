package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;
import edu.mum.cs.cs525.labs.skeleton.domain.Customer;
import edu.mum.cs.cs525.labs.skeleton.domain.commandPattern.*;
import edu.mum.cs.cs525.labs.skeleton.service.AccountService;
import edu.mum.cs.cs525.labs.skeleton.service.AccountServiceImpl;

public class Application {
	public static void main(String[] args) {
		TransactionInvoker transactionInvoker = new TransactionInvoker();
		AccountService accountService = new AccountServiceImpl();
		DepositCommand depositCommand = new DepositCommand(accountService);
		WithdrawCommand withdrawCommand = new WithdrawCommand(accountService);
		TransferCommand transferCommand = new TransferCommand(accountService);
		Command undoCommand;
		TransactionPayload transactionPayload;

		// create 2 accounts;
		accountService.createAccount("1263862", "Frank Brown");
		accountService.createAccount("4253892", "John Doe");

		// use account 1;
		transactionInvoker.setTransaction(depositCommand);
		undoCommand = depositCommand;
		//accountService.deposit("1263862", 240);
		transactionPayload = new TransactionPayload("1263862",
				"", 240, "");
		transactionInvoker.execute(transactionPayload);
		//accountService.deposit("1263862", 529);
		transactionPayload = new TransactionPayload("1263862",
				"", 529, "");
		transactionInvoker.execute(transactionPayload);

		transactionInvoker.setTransaction(withdrawCommand);
		undoCommand = withdrawCommand;
		//accountService.withdraw("1263862", 230);
		transactionPayload = new TransactionPayload("1263862",
				"", 230, "");
		transactionInvoker.execute(transactionPayload);

		//undo transaction
		transactionInvoker.undo(transactionPayload.getToAccount());

		// use account 2;
		transactionInvoker.setTransaction(depositCommand);
		undoCommand = depositCommand;
		//accountService.deposit("4253892", 12450);
		transactionPayload = new TransactionPayload("4253892",
				"", 12450, "");
		transactionInvoker.execute(transactionPayload);

		//accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		transactionInvoker.setTransaction(transferCommand);
		undoCommand = transferCommand;
		transactionPayload = new TransactionPayload("4253892", "1263862",
				100, "payment of invoice 10232");
		transactionInvoker.execute(transactionPayload);


		// show balances

		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			
			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
