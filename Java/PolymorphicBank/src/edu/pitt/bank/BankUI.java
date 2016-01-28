package edu.pitt.bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankUI {

	private JFrame frame;
	private JTextField txtAmount;
	private JButton btnWithdraw;
	private JComboBox cboWithdrawalBehavior;
	private Account account;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankUI window = new BankUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankUI() {
		account = new CheckingAccount(11111, 1000);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(27, 46, 134, 28);
		frame.getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setWithdrawalBehavior((WithdrawalBehavior)cboWithdrawalBehavior.getSelectedItem());
				account.withdraw(Double.parseDouble(txtAmount.getText()));
			}
		});
		btnWithdraw.setBounds(172, 47, 117, 29);
		frame.getContentPane().add(btnWithdraw);
		
		cboWithdrawalBehavior = new JComboBox();
		cboWithdrawalBehavior.addItem(new WithdrawWithPenalty());
		cboWithdrawalBehavior.addItem(new NormalWithdrawal());
		
		cboWithdrawalBehavior.setBounds(27, 18, 262, 27);
		frame.getContentPane().add(cboWithdrawalBehavior);
	}
}
