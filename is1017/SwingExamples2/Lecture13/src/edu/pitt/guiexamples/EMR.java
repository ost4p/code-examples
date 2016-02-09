package edu.pitt.guiexamples;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JTextArea;

public class EMR {

	/* Global variables representing SWING controls for the parent frame */
	private JFrame parentFrame;
	private JLabel lblLabelExample;
	private JLabel lblLabelExample1;
	private JTextField txtTextBoxExample;
	private JComboBox cboComboBoxExample;
	private JButton btnButtonExample;
	
	/* Global variables representing SWING controls for the child (popup) frame */
	private JFrame childFrame;
	private JButton btnButtonExample1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EMR window = new EMR();
		window.parentFrame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public EMR() {
		initParentFrame();
		initChildFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initParentFrame() {
		parentFrame = new JFrame("PARENT FRAME");
		parentFrame.setBounds(100, 100, 600, 400);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.getContentPane().setLayout(null);
		
		lblLabelExample = new JLabel("Example label:");
		lblLabelExample.setBounds(20, 20, 200, 20);
		parentFrame.getContentPane().add(lblLabelExample);
		
		cboComboBoxExample = new JComboBox();
		cboComboBoxExample.setBounds(lblLabelExample.getX() + lblLabelExample.getWidth() + 10, lblLabelExample.getY(), 250, 30);
		String[] names = {"John", "Jane", "Joe", "Max", "Tom"};
		for(String name : names){
			cboComboBoxExample.addItem(name);
		}
		
		
		cboComboBoxExample.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		parentFrame.getContentPane().add(cboComboBoxExample);
		
		lblLabelExample1 = new JLabel("Another label:");
		lblLabelExample1.setBounds(lblLabelExample.getX(), lblLabelExample.getY() + 40, 200, 20);
		parentFrame.getContentPane().add(lblLabelExample1);
		
		txtTextBoxExample = new JTextField();
		txtTextBoxExample.setBounds(lblLabelExample1.getX() + lblLabelExample1.getWidth() + 10, lblLabelExample1.getY(), 250, 30);
		parentFrame.getContentPane().add(txtTextBoxExample);
		
		
		btnButtonExample = new JButton("Button example - Open New Window");
		btnButtonExample.setBounds(txtTextBoxExample.getX(), txtTextBoxExample.getY() + txtTextBoxExample.getHeight(), 300, 30);
		btnButtonExample.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("You just clicked a button!");
				childFrame.setVisible(true);
			}
		});
		parentFrame.getContentPane().add(btnButtonExample);
	}
	
	private void initChildFrame(){
		childFrame = new JFrame("CHILD FRAME");
		childFrame.setBounds(100, 100, 400, 200);
		childFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		childFrame.getContentPane().setLayout(null);
		childFrame.setVisible(false);
		
		btnButtonExample1 = new JButton("Hide This Window");
		btnButtonExample1.setBounds(10, 10, 200, 30);
		btnButtonExample1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				childFrame.setVisible(false);
			}
		});
		childFrame.getContentPane().add(btnButtonExample1);
		
		
		
	}
}
