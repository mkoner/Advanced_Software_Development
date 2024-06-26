package edu.mum.cs.cs525.labs.skeleton;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();
		Observer logger = new Logger();
		Observer emailSender = new EmailSender();
		Observer smsSender = new SMSSender();


		// create 2 accounts;
		Account account1 = accountService.createAccount("1263862", "Frank Brown");
		Account account2 = accountService.createAccount("4253892", "John Doe");
		account1.register(logger);
		account1.register(emailSender);
		account1.register(smsSender);
		account2.register(logger);
		account2.register(emailSender);
		account2.register(smsSender);
		account1.notifyObservers("Account Created");
		account2.notifyObservers("Account Created");
		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
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
