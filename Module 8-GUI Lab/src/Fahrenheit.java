
import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: Initializes a frame with a FahrenheitPanel that allows the user to convert temperatures from Fahrenheit to Celsius.
 * Input: None.
 * Output: Displays a frame with a FahrenheitPanel.
 * Variables: frame, panel.
 * Plan:
 * 1. In the event dispatch field, declares and initializes a JFrame and a FahrenheitPanel and adds the FahrenheitPanel to the 
content pane of the JFrame.
* 2. Displays the JFrame.
* @version 1.0 2013-05-07
 */
public class Fahrenheit {
    //-----------------------------------------------------------------
    //  Creates and displays the temperature converter GUI.
    //-----------------------------------------------------------------

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Fahrenheit");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                FahrenheitPanel panel = new FahrenheitPanel();
                frame.getContentPane().add(panel);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
