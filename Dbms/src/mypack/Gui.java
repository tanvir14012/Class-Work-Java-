package mypack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 23, 185, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(118, 21, 34, 33);
		frame.getContentPane().add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 67, 185, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Dept");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(116, 69, 46, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					 ArrayList<String[]> ans1 = Connect.makeConnection(textField.getText().toString(), textField_1.getText().toString());
					 	Object[][] obj = new Object[ans1.size()-1][];
					 	for(int i = 1; i<ans1.size(); i++) {
					 		obj[i-1] = new Object[Connect.numRows];
					 		for(int j=0; j<Connect.numRows; j++) {
					 			obj[i-1][j] = (Object) ans1.get(i)[j];
					 		}
					 	}
					 	Object[] cols = new Object[Connect.numRows];
					 	for(int i=0; i<Connect.numRows; i++){
					 		cols[i] = ans1.get(0)[i];
					 	}
					 	JTable jtable = new JTable(obj, cols);
					 	JScrollPane scrollPane = new JScrollPane(jtable);
						scrollPane.setBounds(10, 145, 537, 202);
						frame.getContentPane().add(scrollPane);
						frame.setVisible(true);
					 
				
			}
		});
		btnShow.setBounds(233, 111, 89, 23);
		frame.getContentPane().add(btnShow);
		
		
		
		

	}
}
