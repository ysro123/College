
/**
 * @author Arthur Laks
 * CSIT 210 - Classes lab
 * Overview: Stores the information about an account.
 * Variables: long id; double balance,interestRate
 * @version 1.0 2013.04.02
 */
public class Account {
	private long id;
	private double balance,interestRate;
	/**
	 * Initializes an account with the default values (-1 for id, 5 for balance, and 0 for interestRate).
	 */
	public Account(){
		id=-1;
		balance=5;
		interestRate=0;
	}
	/**
	 * Initializes an account with the specified values.
	 * @param id
	 * @param balance
	 */
	public Account(long id,double balance){
		this.id=id;
		this.balance=balance;
	}
	/**
	 * Returns the id of the account.
	 */
	public long getId(){
		return id;
	}
	/**
	 * Sets the id of the account to the specified value.
	 * @param id
	 */
	public void setId(long id){
		this.id=id;
	}
	/**
	 * Returns the balance of the account.
	 */
	public double getBalance(){
		return balance;
	}
	/**
	 * Sets the balance of the account to the specified value.
	 * @param balance
	 */
	public void setBalance(double balance){
		this.balance=balance;
	}
	/**
	 * Returns the interest rate of the account.
	 * @return
	 */
	public double getInterestRate(){
		return interestRate;
	}
	/**
	 * Sets the interest rate of the account to the specified value.
	 * @param interestRate
	 */
	public void setInterestRate(double interestRate){
		this.interestRate=interestRate;
	}
	/**
	 * Withdraws the specified quantity from the account.
	 * @param withdrawal
	 */
	public void withdraw(double withdrawal){
		balance-=withdrawal;
	}
	/**
	 * Deposits the specified value into the account.
	 * @param deposit
	 */
	public void deposit(double deposit){
		balance+=deposit;
	}
	/**
	 * Closes the account by setting the properties to their default values.
	 */
	public void closeAccount(){
		balance=0;
		id=-1;
		interestRate=0;
	}
}
