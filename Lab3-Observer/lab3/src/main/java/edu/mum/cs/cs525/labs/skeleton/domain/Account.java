package edu.mum.cs.cs525.labs.skeleton.domain;

import edu.mum.cs.cs525.labs.skeleton.domain.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account {
	private Customer customer;

	private String accountNumber;
	//private AccountType accountType;
	private String accountType;
	private InterestStrategy interestStrategy;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(){}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
	}

	public void addInterest(){
		AccountEntry entry = new AccountEntry(interestStrategy
				.calculateInterest(getBalance()),
				"Interest", "", "");
		entryList.add(entry);
	}

	public void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		
		entryList.add(fromEntry);
		
		toAccount.addEntry(toEntry);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public InterestStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}
}
