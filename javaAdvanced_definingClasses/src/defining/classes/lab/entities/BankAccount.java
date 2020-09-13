package defining.classes.lab.entities;

public class BankAccount {
	private final static double DEFAULT_INTEREST_RATE = 0.02;
	private static double interest = DEFAULT_INTEREST_RATE;
	private static int bankAccountCount = 1;
	private int id;
	private double balance;
	
	public BankAccount() {
		this.id = bankAccountCount++;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterest(int years) {
		return interest * years * this.balance;
	}
	
	public static void setInterestRate(double interest) {
		BankAccount.interest = interest;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
}
