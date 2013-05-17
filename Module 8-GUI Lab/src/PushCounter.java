
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: Constructs a jFrame containing a PushCounterPanel.
 * Input: None.
 * Output: None.
 * Variables: frame, pane.
 * Plan:
 * 1. In the event dispatch thread, declares a frame that says "Push Counter X Two" in the title-bar.
 * 2. Adds a PushCounterPanel to the content frame of the frame.
 * 3. Sets the background color of the panel to blue, resizes the frame to hold its components, and makes the
height twice the width.
* 4. Displays the frame.
* @version 1.0 2013-05-07
 * @author Aryeh
 */
public class PushCounter
{
   public static void main (String[] args)
    {
        //It is recommended to configure swing components in the event dispatch thread.  Creates an
        //anonymous class extending Runnable() with a run method that creates the thread, and passes it
        //to EventQueue.invokeLater.
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                JFrame frame = new JFrame("Push Counter X Two");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                PushCounterPanel panel = new PushCounterPanel();
                frame.getContentPane().add(panel);
                panel.setBackground(Color.BLUE);
                frame.pack();
                frame.setSize(panel.getWidth(), panel.getWidth() * 2);
                frame.setVisible(true);
            }
        });
    }
}

