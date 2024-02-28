package account;

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
