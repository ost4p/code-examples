package edu.pitt.guiexamples;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class shows how to manage a Combo Box    
 * @author Julio Guerra
 *
 */
public class ComboBoxExample {
	private JFrame frmMainWindow;
	private JComboBox cboOptions;
	private JLabel lblMessage;
	
	public ComboBoxExample(){
		frmMainWindow = new JFrame("Button Example");
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMainWindow.setResizable(false);
        frmMainWindow.setBounds(200,200,350,100);
        frmMainWindow.setLayout(null);
         
        
        lblMessage = new JLabel("");
        lblMessage.setBounds(190,25,150,25);
        lblMessage.setFont(new Font("Arial", 1, 14));
        
        
		String[] options = { "select ...", "be good", "be bad", "be random"};

		// The combobox is created using an array of strings which would be the options
		// each option has an index (starting from 0), as it can be seen below in the 
		// corresponding listener
		cboOptions = new JComboBox(options);
		cboOptions.setBounds(15,25,150,25);
		cboOptions.setSelectedIndex(0);
		
		
		cboOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		// the event object (e) can access the component that generated the 
        		// event (you could eventually attach a listener to many different components).
        		JComboBox cb = (JComboBox)e.getSource();
        		
        		int selectedIndex = cb.getSelectedIndex();
        		
        		if(selectedIndex == 0) lblMessage.setText("");
        		else{
        			boolean good = (selectedIndex == 1) || (selectedIndex == 3 && Math.random() < 0.5);
        			if (good){
            			lblMessage.setText("good evening!");
            			lblMessage.setForeground(Color.BLUE);
            		}else{
            			lblMessage.setText("go hell!");
            			lblMessage.setForeground(Color.RED);
            		}
        		}
            }
        });
		 
		frmMainWindow.add(cboOptions);
		frmMainWindow.add(lblMessage);

		frmMainWindow.setVisible(true);
		
	}
	public static void main(String[] args) {
		ComboBoxExample cbe = new ComboBoxExample();

	}

}
