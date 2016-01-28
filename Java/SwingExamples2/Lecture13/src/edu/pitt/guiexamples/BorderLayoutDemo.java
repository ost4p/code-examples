package edu.pitt.guiexamples;
/*

 * BorderLayoutDemo.java
 *
 */
import javax.swing.*;

import java.awt.BorderLayout;

public class BorderLayoutDemo {
	private JFrame frmMainWindow;
    private JButton btnTop;
    private JButton btnLeft;
    private JButton btnRight;
    private JButton btnCenter;
    private JButton btnBottom;
    
    public BorderLayoutDemo() {
    	// set ups the JFrame
    	frmMainWindow = new JFrame("BorderLayout Demo"); // the contructor allows to specify a title for the window
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
		frmMainWindow.setResizable(true); // the window can be resizable
		frmMainWindow.setBounds(200,200,400,300); // start in the position 200,200 o the screen and it is 350 pixels wide and 100 pixels tall
		frmMainWindow.setLayout(new BorderLayout()); // sets the layout as a BorderLayout
		
		// create the buttons
		btnTop = new JButton("Top");
		btnLeft = new JButton("Left");
		btnRight = new JButton("Right");
		btnCenter = new JButton("Center");
		btnBottom = new JButton("Bottom");
		
		// add buttons to the layout
		frmMainWindow.add(btnTop,BorderLayout.NORTH);
		frmMainWindow.add(btnLeft,BorderLayout.WEST);
		frmMainWindow.add(btnRight,BorderLayout.EAST);
		frmMainWindow.add(btnCenter,BorderLayout.CENTER);
		frmMainWindow.add(btnBottom,BorderLayout.SOUTH);
		
		// display the window
		frmMainWindow.setVisible(true);
    }
    
 
    
    public static void main(String[] args) {
    	BorderLayoutDemo bld = new BorderLayoutDemo();
    }
}