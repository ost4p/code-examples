package edu.pitt.guiexamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class shows how to dealwith JTextArea and JTextField
 * @author Julio Guerra
 *
 */
public class TextExample {
	private JFrame frmMainWindow;
	private JTextField txtInput;
	private JTextArea txtArea;
	private JButton btnAddText;
	private JButton btnResetText;
		
	public TextExample(){
		frmMainWindow = new JFrame("Text Example"); 
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frmMainWindow.setResizable(false); 
        frmMainWindow.setBounds(200,200,450,250); 
        frmMainWindow.setLayout(null);
        
        txtInput = new JTextField();
        txtInput.setBounds(15, 15, 200, 25);
        
        btnAddText = new JButton("Add Text");
        btnAddText.setBounds(215,15,110,25);

        btnResetText = new JButton("Reset Text");
        btnResetText.setBounds(325,15,110,25);
        
        txtArea = new JTextArea(10,25);
        txtArea.setBounds(15,55,415,150);
        
        btnAddText.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if(txtArea.getText().length() == 0) txtArea.setText(txtInput.getText());
        		else txtArea.setText(txtArea.getText() + "\n" + txtInput.getText());
            }
        });
        
        btnResetText.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txtArea.setText("");
            }
        });
        
        
        frmMainWindow.add(txtInput);
        frmMainWindow.add(btnAddText);
        frmMainWindow.add(btnResetText);
        frmMainWindow.add(txtArea);

        frmMainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		TextExample be = new TextExample();
	}

}
