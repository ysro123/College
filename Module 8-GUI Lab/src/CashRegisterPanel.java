import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import javax.swing.*;
/**
 *
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: A panel with one button for each product and a total button.  When the user clicks Total, displays
 the sum of the prices of each product the user picked in a label.
 * Input: The user clicks on buttons representing products to add those products to the shopping cart and total
 to display the price.
 * Output: Displays the price of each product on each button and the total price of the order when the user 
 presses Total.
 * Variables: displayTotal, buttons,total, instructionLabel.
 * Plan: 
 * 1. Keeps track of which product corresponds with each button through a HashMap with button as the key and
 the Product enum as the value.
 * 2. The product enum has a method that returns the price of that product.
 * 3. Creates a button for each product with the name and price of that product on it, and adds the button to 
 the panel and the Map, mapping it to the product it represents.
 * 4. In the button event handler, adds to total the price of the product that the sender is mapped to.
 * 5. Initializes the Total button.  In its event handler, displays total in a label and resets total so that
 the user can start a new order.
 */
public class CashRegisterPanel extends JPanel{
    /**
     * Represents a product and has a method that returns its price.
     */
    public enum Product{
        SMALL_DRINK, LARGE_DRINK, SMALL_FRY, LARGE_FRY, VEGGIE_BURGER, BISON_BURGER; 
        /**
         * Returns the name of the product with spaces and in lower case 
         */
        @Override
        public String toString(){
            String withSpaces = this.name().replace('_',' ');   //Replaces all underscores with spaces.
            return withSpaces.toLowerCase();    //All of the members of the enum are in all-caps to conform
            //to the naming convention.  I would have wanted to make the first letter of each word (or, at
            //least, of each product) uppercase, but I could not find an easy way of doing so.
        }
        /**
         * Calculates the price of the product.
         * @return 
         */
        public double price(){
            //Calculates the price based on the ordinal so that the earlier products are cheaper.  This is 
            //easier than having to implement the price method once per member of the enum.
            return Math.pow((ordinal()/2.0+1),1.5);
        }
    }
    JLabel displayTotal;
    HashMap<JButton,Product> buttons=new HashMap<>();
    JButton totalButton;
    double total=0;
    JLabel instructionLabel;
    public CashRegisterPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        instructionLabel=new JLabel("Click on the buttons with the name of a product to add that product"
                + "to the shopping cart.  Click total to calculate the total price and start a new order.");
        add(instructionLabel);
        //For each product, create a button.
        for(Product thisProduct:Product.values()){
            JButton toCreate=new JButton(String.format("%s - $%.2f",
                    thisProduct.toString(),thisProduct.price()));   //Display the name of the product and the
            //price on each button.
            buttons.put(toCreate,thisProduct);  //Map the button to the product.
            add(toCreate);
            toCreate.addActionListener (new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent event) {
                //Adds the price of the product that is mapped to the sender to total.
                //Casts the return value of event.getSource to a JButton and the return value of buttons.get
                //to Product.
               total+=((Product)(buttons.get((JButton)(event.getSource())))).price();
           }
       });
            displayTotal=new JLabel("Total: ");
        }
        totalButton=new JButton("Total");
        add(totalButton);
        totalButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                NumberFormat formatter=NumberFormat.getCurrencyInstance();
                displayTotal.setText("Total: "+formatter.format(total));
                total=0;
            }
        });
        add(displayTotal);
    }
}
