package penguin;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author Arthur Laks
 * CSIT 210 - Project 1.
 * Overview: Asks the user for the number of sales of each size and then displays the total sales.
 * Input: Asks the user for the name of the franchise and for the number of each size sold.
 * Output: Displays the name of the franchise, the total sales at each product, and a nine-digit confirmation number.
 * Variables: Scanner input; String franchise; double[] prices;Product[] products; Sizes[] sizes; counter; NumberFormat formatter;
 double totalSales; Product thisProduct;
 * Input: Asks the user for the name of the franchise and the number of each product sold.
 * Output: Prints the name of each product, the sales, the price, and the total revenue from that product and a nine-digit
 confirmation code.
 * Plan:
 * 1. Asks the user for the name of the franchise.
 * 2. Initializes arrays of prices and sizes and declares an array of products.
 * 3. Asks the user for the number of sales of each product and initializes the array of products based on the arrays of prices and
 sizes and the numbers that the user enters.
 * 4. Prints the name of the franchise, a border and the column headers.
 * 5. For each product, prints the name of the product, the number of sales, the price, and the total revenue from that product.
 * 6. Adds up the total revenue from each product and prints it.
 * 7. Prints a nine-digit random number as a confirmation code.
 * @version: 1.0 3/5/13
 */
public class DisplaysSales {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("What is the name of the franchise? ");
		String franchise=input.nextLine().toUpperCase();	//Converts the name of the franchise to uppercase.
		//Initializes an array of products by passing the price, size and sales to the constructor of Product.
		//The prices and sizes are hard-coated and stored in arrays but the number of sales is inputed by the user.
		double prices[] = {1.23,2.34,3.45,4.56};
		Product[] products = new Product[4];
		Sizes[] sizes=Sizes.values();
		//For each product, ask the user for the number of sales and initialize a product with that number of sales and the
		//corresponding price and size.
		for(int counter=0;counter<=3;counter++){
			System.out.printf("How many of the size %s were sold? ",sizes[counter].toString());
			int sales=input.nextInt();
			products[counter]=new Product(sizes[counter],prices[counter],sales);
		}
		
		NumberFormat formatter=NumberFormat.getCurrencyInstance();
		System.out.println("\t\t\t"+franchise);
		System.out.println("\t\t //----//----~----\\----\\");
		System.out.println("\t\t # of Sales \t Price\t\t Total");		//Prints the column headers.
		//For each product in the product array, prints one column with the name of the product, one column with the sales, 
		//a column with the price, and the total revenue.
		for(Product thisProduct:products){
			System.out.printf("%-15s",thisProduct.getSize().toString());	//Uses printf to offset the name of the product so that
			//the next column will start at the same place for all products, even Extra Large.
			System.out.print(thisProduct.getSales()+"\t\t");
			System.out.print(formatter.format(thisProduct.getPrice())+" \t\t");
			System.out.println(formatter.format(thisProduct.earnings()));
		}
		//Adds up the total sales by looping through products.
		double totalSales=0;
		for(Product thisProduct:products){
			totalSales+=thisProduct.earnings();
		}
		System.out.println("\t\t Total: \t\t\t "+formatter.format(totalSales));		//Prints the total earnings.
		ThreadLocalRandom generator=ThreadLocalRandom.current();	//ThreadLocalRandom is new to Java 1.7.  In addition 
		//to being thread-safe, it has some improvements over Random, including an overload of nextInt() that takes a minimum
		//and a maximum.  I could have used Random.nextInt(899999999)+10000000 to guarantee that the random number is 9 digits,
		//but I think that this way is more readable.
		System.out.printf("\t\t %s %d", "Confirmation code:" , generator.nextInt(100000000,999999999));		//Generates a
		//nine-digit confirmation code.
		input.close();

	}

}
