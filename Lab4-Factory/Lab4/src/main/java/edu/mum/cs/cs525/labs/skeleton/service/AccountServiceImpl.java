package edu.mum.cs.cs525.labs.skeleton.service;

import edu.mum.cs.cs525.labs.skeleton.domain.Customer;
import edu.mum.cs.cs525.labs.skeleton.domain.Account;
import edu.mum.cs.cs525.labs.skeleton.repository.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.repository.ProdAccountDAOImpl;
import edu.mum.cs.cs525.labs.skeleton.repository.factory.AccountDAOFactory;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private AccountDAOFactory accountDAOFactory;

	@Override
	public void setAccountDAOFactory(AccountDAOFactory accountDAOFactory) {
		this.accountDAOFactory = accountDAOFactory;
		this.accountDAO = accountDAOFactory.createAccountDAO();
	}

	public AccountServiceImpl(AccountDAOFactory accountDAOFactory){
		this.accountDAOFactory = accountDAOFactory;
		this.accountDAO = accountDAOFactory.createAccountDAO();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

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
}
