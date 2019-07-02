import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class Login_ {

	private static String str;
	private static int  count = 0;
	
	public static void main(String[] args) {
		JPasswordField pass= new JPasswordField(10);
		//pass.setActionCommand("OK");
		pass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				str = e.getActionCommand();
				if(str.equals("147") && count <4 ) {
					Try app = new Try();
					app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					app.setSize(480,480);
					app.setVisible(true);
				}
				else {
					++count;
			        JOptionPane.showMessageDialog(null, "Sorry! Invalid password.");
			        if(count >3) {
			        	JOptionPane.showMessageDialog(null, "Thats enough.Goodbye!");
			        	//System.exit(-1);
			        }
				}
			}
		});
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(pass,BorderLayout.NORTH);
	}

}
