//********************************************************************
//  PushCounterPanel.java       Java Foundations
//
//  Demonstrates a graphical user interface and an event listener.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Author: Arthur Laks
 * CSIT 210 - GUI Lab
 * Overview: A panel with a button and a label that displays twice the number of times that the button was
 * pressed.
 * Input: Contains a button.
 * Output: Contains a label that displays twice the number of times that the button was pressed.
 * Variables: count, push, label.
 * Plan: 
 * 1. Initializes a button with an event handler for the click event that displays "Total " and twice 
 the number of times it was clicked on a label.
 * 2. Initializes a label.
 * 3. Adds the label and the button to the panel.
 * @version 1.0 2013-05-07
 */
public class PushCounterPanel extends JPanel
{
   private int count;
   private JButton push;
   private JLabel label;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public PushCounterPanel ()
   {
      count = 0;

      push = new JButton ("Add Two");
      //Uses an anynmous class for the event handler.
      push.addActionListener (new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent event) {
               count += 2;
               label.setText("Total: " + count);
           }
       });

      label = new JLabel ("Total: " + count);

      add (push);
      add (label);

      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 100));
   }
}


