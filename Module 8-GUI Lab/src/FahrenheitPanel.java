//********************************************************************
//  FahrenheitPanel.java       Java Foundations
//
//  Demonstrates the use of text fields.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Author: Arthur Laks
 * CSIT 210-GUI Lab
 * Overview: A panel with a text field in which the user enters a temperature in Fahrenheit and clicks on a button or 
presses enter and the program converts it to Celsius and displays it in a label.
 * Input: Contains a TextField in which the user enters a temperature in Fahrenheit.
 * Output: Contains a label that displays the temperature in Celsius.
 * Variables: inputLabel, outputLabel, resultLabel, convert, fahrenheitTemp, celsiusTemp, text.
 * Plan:
 * 1. Initializes the labels, the button, and the text field.
 * 2. Adds an event listener to the button and the text field that converts the temperature
 in the text field to Celsius and displays it on one of the labels.
 * 3. Adds the components to the panel.
 * @version 1.0 2013-05-07
 */
public class FahrenheitPanel extends JPanel
{
   private JLabel inputLabel, outputLabel, resultLabel;
   private JTextField fahrenheit;
   private JButton convert;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public FahrenheitPanel()
   {
        inputLabel = new JLabel("Enter Fahrenheit temperature:");
        outputLabel = new JLabel("Temperature in Celsius: ");
        resultLabel = new JLabel("---");
        convert = new JButton("Convert");
        convert.addActionListener(new TempListener());
        fahrenheit = new JTextField(5);
        fahrenheit.addActionListener(new TempListener());

        add(inputLabel);
        add(fahrenheit);
        add(outputLabel);
        add(resultLabel);
        add(convert);

        setPreferredSize(new Dimension(300, 75));
        setBackground(Color.yellow);
    }

   //*****************************************************************
   //  Represents an action listener for the temperature input field.
   //*****************************************************************
   private class TempListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Performs the conversion when the enter key is pressed in
      //  the text field.
      //--------------------------------------------------------------
       @Override
      public void actionPerformed (ActionEvent event)
      {
         int fahrenheitTemp, celsiusTemp;

         String text = fahrenheit.getText();

         fahrenheitTemp = Integer.parseInt (text);
         celsiusTemp = (fahrenheitTemp-32) * 5/9;

         resultLabel.setText (Integer.toString (celsiusTemp));
      }
   }
}

