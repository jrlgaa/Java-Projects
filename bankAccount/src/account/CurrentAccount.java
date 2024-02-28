package account;

class CurrentAccount extends BankAccount {

	public void deposit(double amount) {
		balance += amount;
	}


	public void withdraw(double amount) {
		balance -= amount;
	}
}