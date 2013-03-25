
package penguin;


/**
 * @author Arthur Laks
 * CSIT 210 - Project 1
 * Overview: Stores the information about a product and calculates to total revenue from it.
 * Input: none.
 * Output: none.
 * Variables: Sizes size, double price, int sales;
 * Plan:
 * 1. A new instance of Product is declared, with the size, price, and number of sales passed to the constructor.
 * 2. The respective private fields are set to those values.
 * @version: 1.0 3/5/13
 */
public class Product{
	/**
	 * Stores the size of the product (child, medium, large, or Extra Large).
	 */
	private Sizes size;
	private double price;
	private int sales;
	/**
	 * Initializes a product, with the specified size, price, and number of sales.
	 * @param size a member of the Sizes enum, with the size that the product should represent
	 * @param price the price of the product
	 * @param sales the number of sales of the product
	 */
	public Product(Sizes size,double price,int sales){
		this.size=size;
		this.price=price;
		this.sales=sales;
	}
	/**
	 * Calculates the amount of money earned from sales of this product.
	 * @return a double containing the amount of money earned from sales of this product
	 */
	public double earnings(){
		return sales*price;
	}
	/**
	 * Returns the size of the products (Child, Medium etc.).
	 * @return a Sizes enum containing the size of the product.
	 */
	public Sizes getSize(){
		return size;
	}
	/**
	 * Returns the price of the product.
	 * @return the price of the product.
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * Returns the number of sales of the product.
	 * @return the number of sales of the product.
	 */
	public int getSales(){
		return sales;
	}
}
