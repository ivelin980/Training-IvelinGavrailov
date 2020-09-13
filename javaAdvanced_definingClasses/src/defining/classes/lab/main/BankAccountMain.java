package defining.classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import defining.classes.lab.entities.BankAccount;

/**
 * Create class BankAccount. The class should have private fields for: • Id: int
 * (Starts from 1 and increments for every new account) • Balance: double •
 * Interest rate: double (Shared for all accounts. Default value: 0.02) The
 * class should also have public methods for: • setInterestRate(double
 * interest): void (static) • getInterest(int Years): double • deposit(double
 * amount): void Create a test client supporting the following commands: •
 * Create • Deposit {Id} {Amount} • SetInterest {Interest} • GetInterest {ID}
 * {Years} • End
 * 
 * @author Ivelin Gavrailov
 * @since 08.09.2020
 *
 */
public class BankAccountMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayList<BankAccount> accounts = new ArrayList<>();
		while (!"End".equalsIgnoreCase(input)) {
			String[] tokens = input.split(" ");
			switch (tokens[0]) {
			case "Create":
				BankAccount account = new BankAccount();
				accounts.add(account);
				System.out.println(String.format("Account ID%d created", account.getId()));
				break;
			case "Deposit": {
				int id = Integer.parseInt(tokens[1]);
				if (id > 0 && id <= accounts.size()) {
					int amount = Integer.parseInt(tokens[2]);
					accounts.get(id - 1).deposit(amount);
					System.out.println(String.format("Deposited %d to ID%d", amount, id));
				} else {
					System.out.println("Account does not exist");
				}
			}
				break;
			case "SetInterest":
				double interest = Double.parseDouble(tokens[1]);
				BankAccount.setInterestRate(interest);
				break;
			case "GetInterest":
				int id = Integer.parseInt(tokens[1]);
				if (id > 0 && id <= accounts.size()) {
					int years = Integer.parseInt(tokens[2]);
					System.out.println(String.format("%.2f", accounts.get(id - 1).getInterest(years)));
				} else {
					System.out.println("Account does not exist");
				}
				break;
			default:
				break;
			}

			input = scan.nextLine();
		}
		scan.close();
	}
}
