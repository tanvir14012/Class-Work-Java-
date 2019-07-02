package mypack;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Update extends JPanel {
	private JTextField textField;
	private JTextField textField_3;
	private static JButton btnUpdate;

	/**
	 * Create the panel.
	 */
	public Update() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 33, 334, 42);
		add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 131, 334, 42);
		add(textField_3);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblId.setBounds(46, 28, 37, 42);
		add(lblId);
		
		JLabel lblDept = new JLabel("Salary");
		lblDept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDept.setBounds(20, 126, 63, 42);
		add(lblDept);
		
		 btnUpdate = new JButton("Update");
		 btnUpdate.setBounds(189, 246, 89, 23);
			add(btnUpdate);
		 btnUpdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ArrayList<String[]> obj = Trigger.makeConnection(textField.getText().toString(), Integer.parseInt(textField_3.getText()));
		 		JOptionPane.showMessageDialog(null, "Update performed");
		 	}
		 });
		
		

	}

}
