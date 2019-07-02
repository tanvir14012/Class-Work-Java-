import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Try extends JFrame {

	private JPanel contentPane;
	private String str;
	private JTextField textField;
	private double temp1,temp2,ans=0;
	private char op;

	/**
	 * Launch the application.
	 */
	public void make_valid() {
		if(str == null) {
			str = "";
			
		}
		else {
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(!(Character.isDigit(ch) || ch=='.')){
					str = "0";
					return;
				}
			}
			
		}
	}
	public  void Run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Try frame = new Try();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Try() {
		super("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton btnNewButton = new JButton("8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="8";
				textField.setText(str);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(20, 78, 53, 52);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="9";
				textField.setText(str);
			}
		});
		button.setForeground(Color.BLACK);
		button.setBackground(Color.CYAN);
		button.setBounds(94, 78, 53, 52);
		contentPane.add(button);
		
		JButton button_1 = new JButton(".");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+=".";
				textField.setText(str);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.CYAN);
		button_1.setBounds(169, 78, 53, 52);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="4";
				textField.setText(str);
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(Color.CYAN);
		button_2.setBounds(20, 141, 53, 52);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				if(!str.equals("0"))str+="0";
				textField.setText(str);
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(Color.CYAN);
		button_3.setBounds(20, 204, 53, 52);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="5";
				textField.setText(str);
			}
		});
		button_4.setForeground(Color.BLACK);
		button_4.setBackground(Color.CYAN);
		button_4.setBounds(94, 141, 53, 52);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("1");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="1";
				textField.setText(str);
			}
		});
		button_5.setForeground(Color.BLACK);
		button_5.setBackground(Color.CYAN);
		button_5.setBounds(94, 204, 53, 52);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="6";
				textField.setText(str);
			}
		});
		button_6.setForeground(Color.BLACK);
		button_6.setBackground(Color.CYAN);
		button_6.setBounds(169, 141, 53, 52);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("2");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="2";
				textField.setText(str);
			}
		});
		button_7.setForeground(Color.BLACK);
		button_7.setBackground(Color.CYAN);
		button_7.setBounds(169, 204, 53, 52);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("3");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="3";
				textField.setText(str);
			}
		});
		button_8.setForeground(Color.BLACK);
		button_8.setBackground(Color.CYAN);
		button_8.setBounds(243, 204, 53, 52);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("7");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				str+="7";
				textField.setText(str);
			}
		});
		button_9.setForeground(Color.BLACK);
		button_9.setBackground(Color.CYAN);
		button_9.setBounds(243, 141, 53, 52);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("<-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder(str);
				sb.deleteCharAt(str.length()-1);
				str = sb.toString();
				textField.setText(str);
			}
		});
		button_10.setForeground(Color.BLACK);
		button_10.setBackground(Color.CYAN);
		button_10.setBounds(243, 78, 53, 52);
		contentPane.add(button_10);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op = '+';
				if(str.equals("")){
					temp1 = ans;
					textField.setText("");
					return;
				}
				make_valid();
				temp1 = Double.parseDouble(str);
				textField.setText("");
				str = "";
			}
		});
		btnNewButton_1.setBounds(359, 61, 51, 39);
		contentPane.add(btnNewButton_1);
		
		JButton button_11 = new JButton("-");
		button_11.setBackground(Color.YELLOW);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op = '-';
				if(str.equals("")){
					temp1 = ans;
					textField.setText("");
					return;
				}
				make_valid();
				temp1 = Double.parseDouble(str);
				textField.setText("");
				str = "";
			}
		});
		button_11.setBounds(359, 111, 51, 39);
		contentPane.add(button_11);
		
		JButton btnX = new JButton("x");
		btnX.setBackground(Color.YELLOW);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op = '*';
				if(str.equals("")){
					temp1 = ans;
					textField.setText("");
					return;
				}
				make_valid();
				temp1 = Double.parseDouble(str);
				textField.setText("");
				str = "";
			}
		});
		btnX.setBounds(359, 161, 51, 39);
		contentPane.add(btnX);
		
		JButton button_13 = new JButton("/");
		button_13.setBackground(Color.YELLOW);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				op = '/';
				if(str.equals("")){
					temp1 = ans;
					textField.setText("");
					return;
				}
				temp1 = Double.parseDouble(str);
				textField.setText("");
				str = "";
			}
		});
		button_13.setBounds(359, 211, 51, 39);
		contentPane.add(button_13);
		
		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_valid();
				temp2 = Double.parseDouble(str);
				str  = "";
				switch (op)
	            {
	                case '+': ans = temp1 + temp2;
	                    textField.setText(Double.toString(ans));
	                    break;
	                case '-': ans = temp1 - temp2;
	                    textField.setText(Double.toString(ans));
	                    break;
	                case '*': ans = temp1 * temp2;
	                    textField.setText(Double.toString(ans));
	                    break;
	                case '/': 
	                	double f = temp2;
	                    if (f == 0)
	                    {
	                       textField.setText("Undefined");
	                        break;
	                    }
	                    ans = temp1 / f;
	                    textField.setText(Double.toString(ans));
	                    break;
	                default:
	                    break;
	            }   
				
			}
		});
		btnNewButton_2.setBounds(306, 161, 42, 89);
		contentPane.add(btnNewButton_2);
		
		JButton btnCe = new JButton("C");
		btnCe.setBackground(Color.GREEN);
		btnCe.setForeground(new Color(255, 255, 255));
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = "";
				textField.setText("");
				ans = 0;
			}
		});
		btnCe.setBounds(306, 61, 42, 89);
		contentPane.add(btnCe);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(10, 11, 400, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
