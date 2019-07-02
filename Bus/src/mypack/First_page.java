package mypack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class First_page extends JFrame {

	private JPanel contentPane;
	private static Admin_task admin;
	private static Salesman_entry salesman;
	private static JButton btnNewButton;
	private static JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First_page frame = new First_page();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							admin = new Admin_task();
							admin.main_method();
						}
					});
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(salesman == null) {
							salesman = new Salesman_entry(); }
							salesman.Do_transaction();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public static Admin_task getA() {
	return admin;
}
public static Salesman_entry getS() {
	return salesman;
}
	/**
	 * Create the frame.
	 */
	public First_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnMbstuRoadTransport = new JTextPane();
		txtpnMbstuRoadTransport.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 17));
		txtpnMbstuRoadTransport.setEditable(false);
		txtpnMbstuRoadTransport.setForeground(Color.BLUE);
		txtpnMbstuRoadTransport.setText("MBSTU Road Transport Limited");
		txtpnMbstuRoadTransport.setBounds(42, 48, 375, 40);
		contentPane.add(txtpnMbstuRoadTransport);
		
	    btnNewButton = new JButton("Admin");
		
		btnNewButton.setBounds(112, 147, 168, 62);
		contentPane.add(btnNewButton);
		
		 btnNewButton_1 = new JButton("Salesman");
		
		btnNewButton_1.setBounds(112, 242, 168, 62);
		contentPane.add(btnNewButton_1);
		
		
	}
}
