import java.util.Scanner;
/**
 * 
 * @author Arthur Laks
 * CSIT 210 - Classes Lab
 * Overview: Demonstrates the account class
 * Input: Asks the user for the id, balance, and interest rate of an account.
 * Output: Displays the account number and balance of an account.
 * Variables: Account account1, account2; Scanner input;
 * Plan:
 * 1. Initializes an account with hard-coded values.
 * 2. Withdraws from and deposits to the account.
 * 3. Displays information about the account.
 * 4. Declares a new account with default values.
 * 5. Asks the user for information about that account and sets its properties to the values that the user enters.
 * @version 1.0 2013/04/02
 */
public class AccountDemo {
	
	public static void main(String[] args) {
		Account account1=new Account(1234,4321.0);
		account1.setInterestRate(3.2);
		account1.withdraw(3210);
		account1.deposit(2345);
		
		System.out.printf("The account number is %d and the balance is $%.2f.\n",account1.getId(),account1.getBalance());
		
		Account account2=new Account();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the id of the new account: ");
		account2.setId(input.nextLong());
		System.out.println("Enter the balance of the new account: ");
		account2.setBalance(input.nextDouble());
		System.out.println("Enter the interest rate of the new account: ");
		account2.setInterestRate(input.nextDouble());
		input.close();
	}
}
