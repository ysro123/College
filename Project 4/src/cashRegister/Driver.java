/**
 * 
 */
package cashRegister;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Author: Arthur Laks
 * CSIT 210 - Project 4
 * Overview: Displays a JFrame with a CashRegisterPanel
 * @version 1.0 2013-05-12
 */
public class Driver {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){	//Initialize the frame from the event dispatch
			//thread.
			@Override
			public void run(){
				JFrame frame=new JFrame("Cash Register");
				JPanel panel=new CashRegisterPanel();
				frame.add(panel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
