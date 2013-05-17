/**
 * 
 */
package cashRegister;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author Arthur Laks
 * CSIT 210 - Project 4
 * Overview: A for consisting of one button and one label per product.  The user clicks on the
 buttons in order to add that product to the order.  The quantities of each product in the order
 are displayed on the labels.  Also displays the subTotal, tax, and total price of the order.
 When the user enters the payment, displays the total change and the amount of change of each
 denomination.
 * Input: The user clicks on the buttons to add products to the order and enters the payment
to calculate the change and click "Complete Sale" to reset the Labels.
 * Output: Displays the quantities of each product sold and the subtotal, tax and total price
 * of the order.  Also displays the amount of each denomination that has to be returned as 
 change.
 */
@SuppressWarnings("serial")
public class CashRegisterPanel extends JPanel {
	/**
	 * Maps each button to the product that it represents
	 */
	private HashMap<JButton,Product> productButtons=new HashMap<>();
	/**
	 * Maps each product to the JLabel which displays the quantity of the product being purchased
	 */
	private EnumMap<Product,JLabel> productLabels=new EnumMap<>(Product.class);
	/**
	 * The total price of the products in this sale.
	 */
	private double subTotal;
	/**
	 * The total price of the order so far.
	 */
	private double total;
	/**
	 * Stores the total sales of each product for that day.  Maps each product to an Integer that stores the
number of that type of product that was sold.
	 */
	private Map<Product,Integer> totalSales=new EnumMap<>(Product.class);
	private Map<Product,Integer> sales=new EnumMap<>(Product.class);
	private JButton closeOutButton;
	private JButton completeSaleButton;
	private JLabel subTotalDisplay,taxDisplay,totalDisplay,changeDisplay;
	private JTextField paymentTextField;
	private JLabel[] coinLabels=new JLabel[Coin.values().length];
	/**
	 * I am using an initialization block for this because I want the constructor to deal entirely
	 * with initialing and positioning the components.
	 */
	{ // Initialize the sales of each product to 0.
		for (Product cProduct : Product.values()) {
			sales.put(cProduct, 0);
			totalSales.put(cProduct, 0);
		}
	}
	public CashRegisterPanel(){
		setLayout(new GridBagLayout());
		//Add and position the two labels on the top of the form.
		//The titleConstraints object is used for the gridBagConstraints of both of the labels
		//that are centered on the top of the form.  
		GridBagConstraints titleConstraints=getLargeConstraints(1,0,false);
		titleConstraints.gridwidth=5;
		//titleConstraints.weightx=200;
		titleConstraints.anchor=GridBagConstraints.BELOW_BASELINE;
		JLabel titleLabel=new JLabel("Apple IIc - POS System");
		add(titleLabel,titleConstraints);
		JLabel nameLabel=new JLabel("By Arthur Laks");
		titleConstraints.gridy=3;	//Make the nameLabel a line under the titleLabel.
		add(nameLabel,titleConstraints);
		
		int column=0;	//Represents the column that the program is up to.
		//Initialize and position the components on the left column of the form (the buttons
		//that represent the sizes and the sizes label on top of them.
		JLabel sizesLabel=new JLabel("Sizes");
		GridBagConstraints sizesConstraint=getLargeConstraints(column,2,false);
		sizesConstraint.anchor=GridBagConstraints.CENTER;
		add(sizesLabel,sizesConstraint);
		//Create the buttons first so that they would be in the first column and then create the TextFields
		//in the second column.
		//For each product, create a button
		for(Product cProduct:Product.values()){
			JButton toCreate=new JButton(cProduct.toString());
			toCreate.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					onProductButtonClick(e);
				}
			});
			productButtons.put(toCreate, cProduct);
			add(toCreate,getLargeConstraints(column,cProduct.ordinal()+3,true));
		}
		
		column++;
		//Initialize and position the product labels.
		JLabel quantitiesLabel=new JLabel("Quantities");
		add(quantitiesLabel,getLargeConstraints(column,2,false));
		//Adds the labels
		for(Product cProduct:Product.values()){
			JLabel toCreate=new JLabel("0");
			productLabels.put(cProduct, toCreate);
			add(toCreate,getLargeConstraints(column,cProduct.ordinal()+3,true));
		}
		column++;
		//Declare, initialize, and position the display labels for sub-total, tax, total, payment
		//and change
		String[] messages={"Sub-Total","Tax","Total","Payment","Change"};
		for(int counter=0;counter<messages.length;counter++){
			JLabel toCreate=new JLabel(messages[counter]+':');
			GridBagConstraints constraints=getLargeConstraints(column,3+counter,false);
			add(toCreate,constraints);
		}
		
		//Display the labels to display the subtotal, tax, total, and change, and the text field
		//for payment.  All of the display labels start out blank.  The tab is used to make sure
		//that they fill the right amount of space.
		column++;
		subTotalDisplay=new JLabel("\t");
		add(subTotalDisplay,getLargeConstraints(column,3,false));
		taxDisplay=new JLabel("\t");
		add(taxDisplay,getLargeConstraints(column,4,false));
		totalDisplay=new JLabel("\t");
		add(totalDisplay,getLargeConstraints(column,5,false));
		paymentTextField=new JTextField("$00.00");
		paymentTextField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				onPaymentEntry(e);
			}
		});
		add(paymentTextField,getLargeConstraints(column,6,false));
		changeDisplay=new JLabel("\t");
		add(changeDisplay,getLargeConstraints(column,7,false));
		
		column++;
		//Add the label that says "Change" on top of the labels that display the change.
		JLabel changeLabel=new JLabel("Change: ");
		add(changeLabel,getSmallConstraints(column,4));
		//Add blank labels that will display the change when the user enters the payment.
		for(int counter=0;counter<coinLabels.length;counter++){
			coinLabels[counter]=new JLabel("\t\t");
			add(coinLabels[counter],getSmallConstraints(column, counter+5));
		}
		
		column++;
		//Add the close-out and complete sale buttons
		closeOutButton=new JButton("Close Out");
		closeOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCloseOut(e);
				
			}
		});
		add(closeOutButton,getLargeConstraints(column,0,true));
		
		completeSaleButton=new JButton("Complete Sale");
		completeSaleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCompleteSaleButtonClick(e);
			}
		});
		add(completeSaleButton,getLargeConstraints(column,8,true));
	}
	/**
	 * Adds the price of the product that the button represents times the quantity that the user
	 * entered in the text field associated with the product to total.
	 * Adds the quantity of that product sold to the Integer mapped to that product in orders.
	 */
	private void onProductButtonClick(ActionEvent e){
		//product is assigned to the product that is mapped to the button that sent the event.
		Product product=productButtons.get(e.getSource());
		//Find the JLabel that is supposed to display the quantity of that product.
		JLabel quantityLabel=productLabels.get(product);
		sales.put(product, sales.get(product)+1);	//Increment the respective values in 
		//sales and total sales.
		totalSales.put(product, totalSales.get(product)+1);
		subTotal+=product.price();
		quantityLabel.setText(sales.get(product).toString());
		//Update the sub-total, total, and tax text fields.
		updateDisplayLabels();
		
	}
	/**
	 * Updates the quantity labels to reflect the values of the map sales, updates
	 */
	private void updateDisplayLabels(){
		NumberFormat formatter=NumberFormat.getCurrencyInstance();
		subTotalDisplay.setText(formatter.format(subTotal));
		double tax=0.06*subTotal;
		taxDisplay.setText(formatter.format(tax));
		total=tax+subTotal;
		totalDisplay.setText(formatter.format(total));
		changeDisplay.setText("$0.00");
		//Erase the change labels
		for(JLabel cLabel:coinLabels){
			cLabel.setText("\t\t");
		}
	}
	private void onCompleteSaleButtonClick(ActionEvent e){
		//Resets the sales to zero.
		for(Product cProduct:Product.values()){
			sales.put(cProduct, 0);
			productLabels.get(cProduct).setText("0");
		}
		subTotal=total=0;
		paymentTextField.setText("$0.00");
		//Update the display labels to display 0 for the quantities and subtotal, total etc.
		updateDisplayLabels();
	}
	/**
	 * Calculates and displays the total change and the change broken up into denominations (eg.
	 * 1 dollar, 3 quarters, and 2 pennys for $1.77).
	 * @param event
	 */
	private void onPaymentEntry(ActionEvent event){
		double payment=0;
		try{
			payment=Double.parseDouble(paymentTextField.getText().replace('$','\u0000'));
			//Replaces a dollar sign with null so that parseDouble will ignore it.
		}catch(NumberFormatException e){	//If the payment is an invalid number
			JOptionPane.showMessageDialog(this,"The payment must be a valid number."
					,"Cash Register",JOptionPane.ERROR_MESSAGE);
			paymentTextField.setText("0.00");
			return;
		}
		double change=payment-total;
		//If the payment is less than the total (and thus change is less than zero), display
		//an error message, reset the payment and do not show the change.
		if(change<0){
			JOptionPane.showMessageDialog(this,"The payment must be greater than or equal to " +
					"the total price.","Cash Register", JOptionPane.ERROR_MESSAGE);
			paymentTextField.setText("$0.00");
			return;
		}
		//Reset the change labels and then update them based on the value that the user 
		//entered
		for(JLabel cLabel:coinLabels){
			cLabel.setText("\t\t");	//The tabs are used as spacefillers so that the frame
			//would not contract.
		}
		NumberFormat formatter=NumberFormat.getCurrencyInstance();
		
		changeDisplay.setText(formatter.format(change));
		//calculateChange takes an int containing the number of cents.  change has to be
		//Multiplied by 100 and cast to an int to be passed to calculateChange
		Map<Coin,Integer> sortedChange=calculateChange((int)(change*100));
		//Displays the change in the coinLabels.  For each denomination greater than 0 (for
		//example, if the change is $1.01, only dollars and cents are greater than 0), display
		//that denomination in a label.
		int counter=0;	//Keeps track of the number of coinLabels used so far.  It is used as
		//the indexer for coinLabels[].  coinLabels has one label for each coin, but only
		//the ones which are needed are used.  For every coin that is not zero (and has to 
		//be displayed), prints the number of that coin in coinLabels[counter] and increments
		//counter.
		for(Coin cCoin:Coin.values()){
			if(sortedChange.get(cCoin)>0){
				coinLabels[counter].setText(String.format("%d - %s"
						,sortedChange.get(cCoin),formatter.format(cCoin.value()/100d)));
				counter++;
			}
		}
	}
	private void onCloseOut(ActionEvent e) {
		//Ask the user to enter the password
		JPasswordField passwordField=new JPasswordField();
		//Display a label and the password field in a dialog box.  An array of components
		//can be passed to showMessageDialog to display all of them.
		JComponent[] toDisplay={new JLabel("Enter the password here: "),passwordField};
		JOptionPane.showMessageDialog(this, toDisplay, "Cash Register",JOptionPane.INFORMATION_MESSAGE);
		//If the password is correct (passwords are stored in char arrays for security reasons).
		char[] enteredPassword=passwordField.getPassword();
		char[] correctPassowrd={'G','o','o','g','l','e'};
		if(Arrays.equals(enteredPassword, correctPassowrd)){	//If the password is correct.
			//Display a frame with the close out report.
			JFrame frame=new JFrame("Close Out Report");
			CloseOutPanel closeOutPanel=new CloseOutPanel(totalSales);
			frame.getContentPane().add(closeOutPanel);
			frame.pack();
			frame.setVisible(true);
		}else	//If the password was wrong.
			JOptionPane.showMessageDialog(this, "Incorrect Password");
		
	}
	/**
	 * Takes an int containing a sum of money measured in cents (eg. 4326 for $43.26) and returns
	 *  an object mapping each Coin with the number of that coin required to break up that sum
	 *  in the most optimal way.
	 * @param cents
	 * @return
	 */
	private EnumMap<Coin, Integer> calculateChange(int cents) {
		//This method recursively reduces the parameter until the base case, when the parameter
		//is less than 5, when it returns that number of cents.  For example, if 4326 is passed
		//to it, it will first find that it is greater than the greatest coin ($20) so it will
		//call itself with 4326 mod 20 (326) and map Coin.TWENTY in the return value
		//to 4326/2000 (with integer division), so that Coin.TWENTY will be mapped to 2.
		EnumMap<Coin, Integer> retval;
		for (Coin cCoin : Coin.values()) {
			if (cents >= cCoin.value() && cCoin != Coin.PENNY) {	//In the base case (where
				//cents is less than 5 and the loop runs until cCoin is Coin.PENNY), skip to
				//the end of the loop, where the base case is.
				retval = calculateChange(cents % cCoin.value());
				retval.put(cCoin, cents / cCoin.value());
				return retval;
			}
		}
		retval = new EnumMap<>(Coin.class);
		//Initialize all values to 0 then map Coin.PENNY to cents.
		for(Coin cCoin:Coin.values()){
			retval.put(cCoin, 0);
		}
		retval.put(Coin.PENNY, cents);
		return retval;
	}

	/**
	 * Returns a gridBagConstraints that takes up 3/2 times the space of a component made with 
	 * getSmallConstraints (getSmallConstraints sets gridHeight to 2 and this method sets it to 3).
	 * The only components that use small constraints are the change labels to allow all of them
	 * to fit in one column..
	 * @param gridX the column to position the component in
	 * @param gridY the row to place the position in.  It is multiplied by 3 so that if it is 
	 * passed 2, it understands that as 2 large columns which is really 6 columns.
	 * @param fill if true, sets fills the whole cell and is centered.  Otherwise, it is aligned
	 * right.
	 * @return
	 */
	public static GridBagConstraints getLargeConstraints(int gridX,int gridY,boolean fill){
		GridBagConstraints retval=new GridBagConstraints();
		retval.gridx=gridX;
		retval.gridy=3*gridY;
		retval.gridheight=3;
		retval.gridwidth=1;
		retval.weightx=100;
		retval.weighty=33;
		retval.ipadx=20;
		if(fill)
			retval.fill=GridBagConstraints.BOTH;
		else{
			retval.fill=GridBagConstraints.NONE;
			retval.anchor=GridBagConstraints.WEST;	//Align left
		}
		return retval;
	}
	/**
	 * Initializes a small GridBagConstraints for components in short column (which are really
	 * 2 columns, unlike large columns which are 3).
	 * @param gridX
	 * @param gridY
	 * @return
	 */
	private GridBagConstraints getSmallConstraints(int gridX,int gridY){
		GridBagConstraints retval=new GridBagConstraints();
		retval.gridx=gridX;
		retval.gridy=2*gridY;
		retval.weightx=100;
		retval.weighty=33;
		retval.anchor=GridBagConstraints.WEST;
		return retval;
		
	}
}
