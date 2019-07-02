package mypack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Searching_journey extends JFrame {

	private JPanel contentPane;
	private static Searching_journey frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JButton btnSubmit;
	private static String from,to,time;
	private static boolean status;
	/**
	 * Launch the application.
	 */
	public static boolean main_method(String a,String b,String c) {
		from = a;
		to = b;
		time = c;
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				try {
					 frame = new Searching_journey(from,to,time);
					 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					
					btnSubmit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(textField.getText().equals("") ||textField_1.getText().equals("")
								||	textField_2.getText().equals("")	)
							{
								JOptionPane.showMessageDialog(null,"Fill all fields please");
								status = false;
							}
							else {
								if(textField.getText().toString().equals(from) &&
								textField_1.getText().toString().equals(to) &&
								textField_2.getText().toString().equals(time)) {
									JOptionPane.showMessageDialog(null,"Transport available");
									status = true;
								frame.setVisible(false);
								frame.dispose();
								Seat_booking temp = new Seat_booking();
								temp.main_method();/**/
								}
								else {
									JOptionPane.showMessageDialog(null,"Transport Unavailable");
									frame.setVisible(false);
									frame.dispose();
								}
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		//});
		return status;
	}

	/**
	 * Create the frame.
	 */
	public Searching_journey(String from,String
			to,String time) {
		super("Salesman prompt");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFrom = new JLabel("From :");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFrom.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.EAST;
		gbc_lblFrom.gridx = 2;
		gbc_lblFrom.gridy = 2;
		contentPane.add(lblFrom, gbc_lblFrom);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		 
		 JLabel lblTo = new JLabel("To :");
		 lblTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		 GridBagConstraints gbc_lblTo = new GridBagConstraints();
		 gbc_lblTo.anchor = GridBagConstraints.EAST;
		 gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTo.gridx = 2;
		 gbc_lblTo.gridy = 4;
		 contentPane.add(lblTo, gbc_lblTo);
		 
		 textField_1 = new JTextField();
		 GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		 gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		 gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_1.gridx = 3;
		 gbc_textField_1.gridy = 4;
		 contentPane.add(textField_1, gbc_textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel lblTime = new JLabel("Time :");
		 lblTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		 GridBagConstraints gbc_lblTime = new GridBagConstraints();
		 gbc_lblTime.anchor = GridBagConstraints.EAST;
		 gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTime.gridx = 2;
		 gbc_lblTime.gridy = 6;
		 contentPane.add(lblTime, gbc_lblTime);
		 
		 textField_2 = new JTextField();
		 GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		 gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		 gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_2.gridx = 3;
		 gbc_textField_2.gridy = 6;
		 contentPane.add(textField_2, gbc_textField_2);
		 textField_2.setColumns(10);
		
		 btnSubmit = new JButton("Submit");
		 
		 btnSubmit.setBackground(Color.RED);
		 btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		 GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		 gbc_btnSubmit.gridx = 3;
		 gbc_btnSubmit.gridy = 7;
		 contentPane.add(btnSubmit, gbc_btnSubmit);
	}

}
