import java.awt.EventQueue;
import javax.swing.*;

/**
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: Displays a frame with a PayrollPanel.
 * Input: none.
 * Output: none.
 * Variables: frame, panel.
 * Plan: 
 * 1. Initializes a JFrame with "Payroll" on the title-bar.
 * 2. Initializes a PayrollPanel and adds it to the content frame of the JFrame.
 * @version 1.0 2013-05-07.
 */
public class PayrollDriver {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame=new JFrame("Payroll");
                PayrollPanel panel=new PayrollPanel();
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
