package mypack;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Show extends JFrame{
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Show() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("myaudit table");
		lblNewLabel.setBounds(165, 11, 160, 27);
		add(lblNewLabel);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Hell performed");
				
			}
		});
		btnShow.setBounds(157, 34, 89, 23);
		add(btnShow);
		

	}
}
