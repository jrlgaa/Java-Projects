abstract class BankAccount {
	protected double balance;

	public BankAccount() {
		balance = 0;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public double getBalance() {
		return balance;
	}
}

class SavingsAccount extends BankAccount {
	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
}

class CurrentAccount extends BankAccount {
	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}
}

public class MyAccount {
	public static void main(String[] args) {
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.deposit(2000);
		savingsAccount.withdraw(1500);

		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.deposit(4000);
		currentAccount.withdraw(2000);

		System.out.println("[SAVINGS ACCOUNT]:");
		System.out.printf("Total amount of money deposited to your savings bank account is: Php%.2f\n", savingsAccount.getBalance());
		System.out.printf("Total amount of money withdrawn from your savings bank account is: Php%.2f\n", 2000 - savingsAccount.getBalance());

		System.out.println("\n[CURRENT ACCOUNT]:");
		System.out.printf("Total amount of money deposited to your current bank account is: Php%.2f\n", currentAccount.getBalance());
		System.out.printf("Total amount of money withdrawn from your current bank account is: Php%.2f\n", 4000 - currentAccount.getBalance());
	}
}