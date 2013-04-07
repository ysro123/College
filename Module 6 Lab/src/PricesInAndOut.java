import java.util.Scanner;
import java.text.NumberFormat;
/**
 * Arthur Laks
 * CSIT 210 - Arrays Lab Part 1
 * Overview: Inputs an array of prices, outputs them and their sum, and outputs them in reverse order.
 * Input: Asks the user to enter four prices.
 * Output: Displays those prices, their sum, and the prices in reverse order.
 * Variables: input, currencyFormat, prices, sum
 * Plan:
 * 1. Declares and initializes an array of doubles.
 * 2. Populates it by asking the user to enter four prices, adding each one to a double called sum.
 * 3. Displays the prices that the user entered and the sum.
 * 4. Displays those prices in reverse order.
 * @version 1.0 2013-04-16
 */
public class PricesInAndOut {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		NumberFormat currencyFormat=NumberFormat.getCurrencyInstance();
		double[] prices=new double[4];
		double sum=0;
		for(int counter=0;counter<prices.length;counter++){
			System.out.printf("Enter price #%d: ",counter+1);
			prices[counter]=input.nextDouble();
			sum+=prices[counter];
		}
		System.out.print("Here is a list of the prices: ");
		for(double cPrice:prices){
			System.out.print(currencyFormat.format(cPrice)+"; ");
		}
		System.out.println();
		System.out.println("The sum of all of the prices is "+currencyFormat.format(sum));
		System.out.print("In reverse order, the prices are ");
		for(int counter=prices.length-1;counter>=0;counter--){
			System.out.print(currencyFormat.format(prices[counter])+"; ");
		}
		input.close();
	}

}
