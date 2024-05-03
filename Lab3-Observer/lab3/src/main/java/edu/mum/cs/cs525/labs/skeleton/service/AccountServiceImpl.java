package edu.mum.cs.cs525.labs.skeleton.service;

import edu.mum.cs.cs525.labs.skeleton.domain.strategy.CheckingInterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.domain.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.domain.strategy.SavingsInterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.domain.Customer;
import edu.mum.cs.cs525.labs.skeleton.repository.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.domain.AccountDAOImpl;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	InterestStrategy checkingInterestStrategy = new CheckingInterestStrategy();
	InterestStrategy savingInterestStrategy = new SavingsInterestStrategy();
	
	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName, String accountType) {
		Account account = new Account(accountNumber);
		account.setAccountType(accountType);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		if(accountType.equals("checking"))
			account.setInterestStrategy(checkingInterestStrategy);
		if(accountType.equals("saving"))
			account.setInterestStrategy(savingInterestStrategy);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	@Override
	public void addInterest() {
		Collection<Account> accounts = accountDAO.getAccounts();
		for (Account account : accounts) {
			account.addInterest();
		}
	}
}
