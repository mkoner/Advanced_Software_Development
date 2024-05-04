package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;
import edu.mum.cs.cs525.labs.skeleton.domain.Customer;
import edu.mum.cs.cs525.labs.skeleton.repository.factory.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.repository.factory.MockAccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.repository.factory.ProdAccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.service.AccountService;
import edu.mum.cs.cs525.labs.skeleton.service.AccountServiceImpl;

import java.util.Collection;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		AccountDAOFactory prodFactory = new ProdAccountDAOFactory();
		AccountDAOFactory mock = new MockAccountDAOFactory();
		AccountService accountService = new AccountServiceImpl(prodFactory);

		// create 2 accounts;
		accountService.createAccount("1263862", "Frank Brown");
		accountService.createAccount("4253892", "John Doe");
		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		// show balances

		printAccounts(accountService.getAllAccounts());

		System.out.println("Using mock");
		accountService.setAccountDAOFactory(mock);
		accountService.createAccount("1263862", "Frank Mock");
		accountService.deposit("1263862", 40);
		accountService.deposit("1263862", 29);
		accountService.withdraw("1263862", 20);
		printAccounts(accountService.getAllAccounts());

		System.out.println("Switching to prod");
		accountService.setAccountDAOFactory(prodFactory);
		printAccounts(accountService.getAllAccounts());
	}

	private static void printAccounts(Collection<Account> accounts) {
		for (Account account : accounts) {
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
