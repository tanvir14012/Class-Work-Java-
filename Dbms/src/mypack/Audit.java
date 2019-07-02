package mypack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Audit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public Audit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String[]> ans1 = Trigger.makeConnection("-147",1);
			 	Object[][] obj = new Object[ans1.size()-1][];
			 	for(int i = 1; i<ans1.size(); i++) {
			 		obj[i-1] = new Object[Trigger.numRows];
			 		for(int j=0; j<Trigger.numRows; j++) {
			 			obj[i-1][j] = (Object) ans1.get(i)[j];
			 		}
			 	}
			 	Object[] cols = new Object[Trigger.numRows];
			 	for(int i=0; i<Trigger.numRows; i++){
			 		cols[i] = ans1.get(0)[i];
			 		System.out.println("sss "+ cols[i].toString());
			 	}
			 	JTable jtable = new JTable(obj, cols);
				contentPane.add(new JScrollPane(jtable));
				contentPane.setVisible(true);
				contentPane.revalidate();
			}
		});
		contentPane.add(btnShow, BorderLayout.NORTH);
	}

}
