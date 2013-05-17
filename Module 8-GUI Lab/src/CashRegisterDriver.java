
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: Displays a JFrame with a CashRegisterPanel.
 * Input: None.
 * Output: Displays a JFrame with a CashRegisterPanel.
 * Plan: 
 * 1. In the event dispatch thread, initializes a JFrame, adds a CashRegisterPanel to its content frame, and
 displays the Frame.
 * Variables: frame, panel.
 * @version 1.0 2013-05-08
 */
public class CashRegisterDriver {
    public static void main(String[] args){
            EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame=new JFrame("Cash Register");
                CashRegisterPanel panel=new CashRegisterPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
