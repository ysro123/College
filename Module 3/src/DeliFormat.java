import java.util.Scanner;
import java.text.*;
/**
 * @author Arthur Laks
 * CSIT 210 - Formatting Output
 * Overview:Computes the price of a deli item given the weight (in ounces) and price per pound -- prints a label, nicely formatted,
  for the item.
  * Input: Asks the user for the price per pound and the weight of the order.
  * Output: Displays the unit price, the weight of the order in pounds, and the total price.
  * Variables: final double OUNCE_PER_POUND; double weightOunces,weight,totalPrice; Scanner scan; NumberFormat money;
 DecimalFormat fmt;
  *Plan:
  *1. Asks the user for the price per pound and the weight of the order in ounces.
  *2. Converts the weight into pounds and calculates the total price.
  *3. Displays the label consisting of the unit price (that the user entered), the weight in pounds, and the total price.
  *@version: 1.0 February 26, 2013.
 */
public class DeliFormat {
	public static void main(String[] args) {
		final double OUNCES_PER_POUND = 16.0;
		double pricePerPound; // price per pound
		double weightOunces; // weight in ounces
		double weight; // weight in pounds
		double totalPrice; // total price for the item
		Scanner scan = new Scanner(System.in);
		// Declare money as a NumberFormat object and use the
		// getCurrencyInstance method to assign it a value
		NumberFormat money =NumberFormat.getCurrencyInstance();
		// Declare fmt as a DecimalFormat object and instantiate
		// it to format numbers with at least one digit to the left of the
		// decimal and the fractional part rounded to two digits.
		DecimalFormat fmt=new DecimalFormat("0.##");
		// prompt the user and read in each input
		System.out.println ("Welcome to the Whole Foods Deli!!\n ");
		System.out.print ("Enter the price per pound of your item: ");
		pricePerPound = scan.nextDouble();
		System.out.print ("Enter the weight (ounces): ");
		weightOunces = scan.nextDouble();
		// Convert ounces to pounds and compute the total price
		weight=weightOunces/OUNCES_PER_POUND;
		totalPrice=pricePerPound*weight;
		// Print the label using the formatting objects
		// fmt for the weight in pounds and money for the prices
		System.out.println("***** Whole Foods Deli ******");
		System.out.println();
		System.out.println("Unit Price: "+money.format(pricePerPound)+" per pound");
		System.out.println("Weight: "+fmt.format(weight)+" pounds");
		System.out.println();
		System.out.println("TOTAL: "+money.format(totalPrice));
		scan.close();
	}

}
