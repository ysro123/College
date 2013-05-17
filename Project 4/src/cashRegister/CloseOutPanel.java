/**
 * 
 */
package cashRegister;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.Map;

/**
 * Author: Arthur Laks
 * CSIT 210 - Project 4
 * Overview: Displays the total sales for that day, based on the map passed to it by CashRegisterPanel.
 * Input: None.
 * Output: Displays the number of each product sold and the subTotal, tax, and total.
 *
 */
public class CloseOutPanel extends JPanel {
	/**
	 * Very similar to the constructor of CashRegisterPanel.
	 * @param sales a Map mapping each product to the number of sales.
	 */
	public CloseOutPanel(Map<Product,Integer> sales){
		setLayout(new GridBagLayout());
		JLabel title=new JLabel("Apple IIc-POS System\nBy Arthur Laks");	//This label contains
		//two lines.
		GridBagConstraints titleConstraints=getConstraints(1,0,true);
		titleConstraints.gridwidth=2;
		titleConstraints.gridheight=2;
		add(title,titleConstraints);
		
		//Display the sizes and quantities labels on top of the first two columns.
		JLabel sizesLabel=new JLabel("Sizes");
		add(sizesLabel,getConstraints(0,2,true));
		JLabel quantitiesLabel=new JLabel("Quantities");
		add(quantitiesLabel,getConstraints(1,2,true));
		//Display the buttons for the products and the labels for the quantities.
		for(Product cProduct:Product.values()){	
			int row=3+cProduct.ordinal();	//The of them is on the 4th row (3 is 0-based).
			JButton productButton=new JButton(cProduct.toString());
			add(productButton,getConstraints(0,row,true));
			
			JLabel quantityLabel=new JLabel(sales.get(cProduct).toString());
			add(quantityLabel,getConstraints(1,row,false));
		}
		//The text of the labels to the left of the displays for sub-total, tax, etc.
		String[] messages={"Sub-Total:","","Tax:","Total:"};	//One line is skipped between
		//sub-total and tax.
		//Create a label for each message.
		for(int counter=0;counter<messages.length;counter++){
			JLabel toCreate=new JLabel(messages[counter]);
			add(toCreate,getConstraints(2,3+counter,false));
		}
		//Calculate the subTotal, tax, and total based on the map that was passed as the paremeter
		double subTotal=0d;
		for(Product cProduct:Product.values()){
			subTotal+=sales.get(cProduct)*cProduct.price();	//Multily the quantity by the price.
		}
		double tax=0.06*subTotal;
		double total=tax+subTotal;
		//Display the subTotal, total, and tax.
		NumberFormat format=NumberFormat.getCurrencyInstance();
		JLabel subTotalDisplay=new JLabel(format.format(subTotal));
		add(subTotalDisplay,getConstraints(3,3,false));
		JLabel taxDisplay=new JLabel(format.format(tax));
		add(taxDisplay,getConstraints(3,5,false));
		JLabel totalDisplay=new JLabel(format.format(total));
		add(totalDisplay,getConstraints(3,6,false));
		
		JButton closeOutButton=new JButton("Close Out");
		//Exits the program when the button is clicked.
		closeOutButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				}
		});
		add(closeOutButton,getConstraints(6,0,true));
	}
	/**
	 * See documentation for getLargeConstraints in CashRegisterPanel.  Since all components
	 * in this panel are of the same height, gridHeight is left at one.
	 * @param gridX
	 * @param gridY
	 * @param fill
	 * @return
	 */
	private GridBagConstraints getConstraints(int gridX, int gridY,boolean fill){
		GridBagConstraints retval=new GridBagConstraints();
		retval.gridx=gridX;
		retval.gridy=gridY;
		retval.weightx=retval.weighty=100;
		if(fill){
			retval.fill=GridBagConstraints.BOTH;
			}else{
				retval.fill=GridBagConstraints.NONE;
				retval.anchor=GridBagConstraints.WEST;
			}
		return retval;
	}
}
