package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountEntry;
import edu.mum.cs.cs525.labs.skeleton.domain.Customer;
import edu.mum.cs.cs525.labs.skeleton.domain.decorator.InterestPromotionDecorator;
import edu.mum.cs.cs525.labs.skeleton.domain.decorator.P1;
import edu.mum.cs.cs525.labs.skeleton.domain.decorator.P2;
import edu.mum.cs.cs525.labs.skeleton.domain.decorator.P3;
import edu.mum.cs.cs525.labs.skeleton.service.AccountService;
import edu.mum.cs.cs525.labs.skeleton.service.AccountServiceImpl;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		// create 2 accounts;
		Account account1 = accountService.createAccount("1263862", "Frank Brown", "checking");
		Account account2 = accountService.createAccount("4253892", "John Doe", "saving");
		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");

		accountService.addInterest();

		InterestPromotionDecorator a = new P1(account1);
		InterestPromotionDecorator b = new P2(account2);
		InterestPromotionDecorator c = new P3(account2);
		a.addInterest();
		b.addInterest();
		c.addInterest();

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
