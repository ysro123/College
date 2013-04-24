import java.util.Scanner;
import java.text.NumberFormat;
/**
 * Arthur Laks 
 * CSIT 210 - Arrays Lab part 1
 * Overview: Asks the user for three prices and quantities, multiplies each price by its corresponding 
quantity, and outputs the result.
 * Input: Asks the user for three prices and quantities
 * Output: Displays the three amounts.
 * Variables: input, price[], qty[], counter, amt[], formatter
 * Plan:
 * 1. Declares arrays to store the prices and quantities.
 * 2. Populates those arrays by asking the user for the prices and quantities.
 * 3. Declares an array and fills it with the product of each value in the arrays of prices and quantities.
 * 4. Displays array of amounts.
 * @version 1.0 2013-04-13
 */
public class ShoppingCart {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double[] price=new double[3];
		int[] qty=new int[3];
		for(int counter=0;counter<price.length;counter++){
			System.out.printf("What is the price of item %d? ", counter+1);
			price[counter]=input.nextDouble();
			System.out.printf("What is the quantity of item %d? ",counter+1);
			qty[counter]=input.nextInt();
		}
		double[] amt=fillAmounts(qty,price);
		NumberFormat formatter=NumberFormat.getCurrencyInstance();
		for(int counter=0;counter<amt.length;counter++){
			System.out.printf("The amount of item %d is %s.\n", counter+1,formatter.format(amt[counter]));
		}
		input.close();
	}
	private static double[] fillAmounts(int[] quantity,double[] price){
		double[] retval=new double[quantity.length];
		for(int counter=0;counter<quantity.length;counter++){
			retval[counter]=quantity[counter]*price[counter];
		}
		return retval;
	}
}
