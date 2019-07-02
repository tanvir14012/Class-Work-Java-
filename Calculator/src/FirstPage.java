import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class FirstPage {

	private static char[] str;
	private static int  count = 0;
	private static JLabel lb;
	private static JButton btn;
	private static JPasswordField pass;
	private static char[] ans = {'1','4','7'};
	
	public static void main(String[] args) {
		lb = new JLabel("Enter Password: ");
		btn = new JButton("OK");
	    pass= new JPasswordField(20);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				str = pass.getPassword();
				System.out.println(str);
				if(Arrays.equals(str, ans) && count <4 ) {
					Try app = new Try();
					app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					app.setSize(480,350);
					app.setVisible(true);
				}
				else {
					++count;
			        JOptionPane.showMessageDialog(null, "Sorry! Invalid password.");
			        if(count >3) {
			        	JOptionPane.showMessageDialog(null, "Thats enough.Goodbye!");
			        	System.exit(-1);
			        }
				}
			}
		});
		
		JFrame frame = new JFrame("Admin Login");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		constraints.gridx = 0;
		constraints.gridy = 0;
		frame.add(lb, constraints);
		
		constraints.gridy = 1;
		frame.add(pass, constraints);
		constraints.gridy = 2;
		frame.add(btn,constraints);
		frame.setVisible(true);
		frame.setSize(480,350);
	}

}
