package mypack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Seat_booking extends JFrame {

	private static Seat_booking frame;
	//private JTextField textField_1;
	private static JButton btnTerminate;
	private static JButton btnOk;
	private static JButton btnCancel;
	private static JTextField txtKol;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JCheckBox checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6,
	checkBox_7,checkBox_8,checkBox_9,checkBox_10,checkBox_11,checkBox_12,checkBox_13,
	checkBox_14,checkBox_15,checkBox_16,checkBox_17,checkBox_18,checkBox_19,checkBox_20;
	private static int count,count1=0;
	private static boolean[] booked;
	private static int seats;
	private static ActionHandler checkbox_listener;

	/**
	 * Launch the application.
	 */
	public static void get_count() {
		
	 if(txtKol != null && txtKol.getText().toString().equals("")!=true) {
			count = Integer.parseInt(txtKol.getText().toString());
				}
			else {
				count = 0;
			}
		
	}
	public static void tracker(int c)
	{
		count1 = c;
	}
	public static void fix_checkbox(boolean[] booked) {
		checkBox_1.setEnabled(!booked[0]);
		checkBox_2.setEnabled(!booked[1]);
		checkBox_3.setEnabled(!booked[2]);
		checkBox_4.setEnabled(!booked[3]);
		checkBox_5.setEnabled(!booked[4]);
		checkBox_6.setEnabled(!booked[5]);
		checkBox_7.setEnabled(!booked[6]);
		checkBox_8.setEnabled(!booked[7]);
		checkBox_9.setEnabled(!booked[8]);
		checkBox_10.setEnabled(!booked[9]);
		checkBox_11.setEnabled(!booked[10]);
		checkBox_12.setEnabled(!booked[11]);
		checkBox_13.setEnabled(!booked[12]);
		checkBox_14.setEnabled(!booked[13]);
		checkBox_15.setEnabled(!booked[14]);
		checkBox_16.setEnabled(!booked[15]);
		checkBox_17.setEnabled(!booked[16]);
		checkBox_18.setEnabled(!booked[17]);
		checkBox_19.setEnabled(!booked[18]);
		checkBox_20.setEnabled(!booked[19]);
	}
	public static boolean available() {
		int temp = 0;
		for(int i = 0; i<booked.length; i++) {
			if(booked[i] == false) {
				temp ++;
			}
		}
			if(temp<count) {
				return false;
			}
			return true;		
	}
	public static void get_boolean() {
		booked = Salesman_entry.give_boolean();
		fix_checkbox(booked);
		seats = Salesman_entry.give_seats();
	}
	public static void main_method() {
		//EventQueue.invokeLater(new Runnable() {
			//public  void run() {
				try {
					 frame = new Seat_booking();
					 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					
					get_boolean();
					

					btnOk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(available()) {
									
								Salesman_entry.update(booked);
								try {
									FileOutputStream fout = new FileOutputStream("salesman.txt",true);
									PrintStream p = new PrintStream(fout);
									p.println();
									p.println(textField_2.getText().toString());
									p.println(textField_3.getText().toString());
									p.println("No. of seats = " + txtKol.getText().toString());
									p.println();
									p.close();
									fout.close();
									JOptionPane.showMessageDialog(null,"Entry Successful");
									frame.setVisible(false);
									frame.dispose();
								}catch(Exception ex) {
									ex.getMessage();
								}
								}
								else {
									JOptionPane.showMessageDialog(null, "Sorry, Wrong input or Unavailable!");
				
							}
						}
					});
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.setVisible(false);
							frame.dispose();
							//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
					});
					btnTerminate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								FileOutputStream fout = new FileOutputStream("finalized.txt");
								PrintStream p = new PrintStream(fout);
								p.println("Total seats = " + seats);
								int x = 0;
								for(int i = 0; i<booked.length; i++) {
									if(booked[i]==false) {
										p.println(String.format("Seat No. %d is empty",i+1));
										x++;
									}
								}
								p.println(String.format("Total empty seats = %d",x));
								p.close();
								fout.close();
								File f = new File("inter_result.txt");
								f.delete();
								frame.setVisible(false);
								frame.dispose();
								//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							}catch(Exception ex) {
								ex.getMessage();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		//});
	}

	/**
	 * Create the frame.
	 */
	public Seat_booking() {
		count1 = -147;
		setBounds(100, 100, 513, 386);
		getContentPane().setLayout(null);
		
		txtKol = new JTextField();
		txtKol.setBounds(31, 11, 52, 43);
		getContentPane().add(txtKol);
		txtKol.setColumns(10);
		
		JLabel lblNoOfSeats = new JLabel("No. of seats");
		lblNoOfSeats.setBounds(25, 66, 72, 14);
		getContentPane().add(lblNoOfSeats);
		
		checkBox_20 = new JCheckBox("20");
		checkBox_20.setBounds(130, 62, 45, 23);
		getContentPane().add(checkBox_20);
		
		checkBox_19 = new JCheckBox("19");
		checkBox_19.setBounds(177, 62, 45, 23);
		getContentPane().add(checkBox_19);
		
		checkBox_1 = new JCheckBox("1");
		checkBox_1.setBounds(223, 62, 45, 23);
		getContentPane().add(checkBox_1);
		
		checkBox_2 = new JCheckBox("2");
		checkBox_2.setBounds(316, 62, 45, 23);
		getContentPane().add(checkBox_2);
		
		checkBox_3 = new JCheckBox("3");
		checkBox_3.setBounds(363, 62, 45, 23);
		getContentPane().add(checkBox_3);
		
		checkBox_4 = new JCheckBox("4");
		checkBox_4.setBounds(130, 99, 45, 23);
		getContentPane().add(checkBox_4);
		
		checkBox_5 = new JCheckBox("5");
		checkBox_5.setBounds(177, 99, 45, 23);
		getContentPane().add(checkBox_5);
		
		checkBox_6 = new JCheckBox("6");
		checkBox_6.setBounds(223, 99, 45, 23);
		getContentPane().add(checkBox_6);
		
		checkBox_7 = new JCheckBox("7");
		checkBox_7.setBounds(316, 99, 45, 23);
		getContentPane().add(checkBox_7);
		
		checkBox_8 = new JCheckBox("8");
		checkBox_8.setBounds(363, 99, 45, 23);
		getContentPane().add(checkBox_8);
		
		checkBox_9 = new JCheckBox("9");
		checkBox_9.setBounds(130, 136, 45, 23);
		getContentPane().add(checkBox_9);
		
		checkBox_10 = new JCheckBox("10");
		checkBox_10.setBounds(177, 136, 45, 23);
		getContentPane().add(checkBox_10);
		
		checkBox_11 = new JCheckBox("11");
		checkBox_11.setBounds(223, 136, 45, 23);
		getContentPane().add(checkBox_11);
		
		checkBox_12 = new JCheckBox("12");
		checkBox_12.setBounds(316, 136, 45, 23);
		getContentPane().add(checkBox_12);
		
		checkBox_13 = new JCheckBox("13");
		checkBox_13.setBounds(363, 136, 45, 23);
		getContentPane().add(checkBox_13);
		
		checkBox_14 = new JCheckBox("14");
		checkBox_14.setBounds(130, 173, 45, 23);
		getContentPane().add(checkBox_14);
		
		checkBox_15 = new JCheckBox("15");
		checkBox_15.setBounds(177, 173, 45, 23);
		getContentPane().add(checkBox_15);
		
		checkBox_16 = new JCheckBox("16");
		checkBox_16.setBounds(223, 173, 45, 23);
		getContentPane().add(checkBox_16);
		
		checkBox_17 = new JCheckBox("17");
		checkBox_17.setBounds(316, 173, 45, 23);
		getContentPane().add(checkBox_17);
		
		checkBox_18 = new JCheckBox("18");
		checkBox_18.setBounds(363, 173, 45, 23);
		getContentPane().add(checkBox_18);
		 
		checkbox_listener = new ActionHandler();
		checkBox_1.addActionListener(checkbox_listener);
		checkBox_2.addActionListener(checkbox_listener);
		checkBox_3.addActionListener(checkbox_listener);
		checkBox_4.addActionListener(checkbox_listener);
		checkBox_5.addActionListener(checkbox_listener);		
		checkBox_6.addActionListener(checkbox_listener);
		checkBox_7.addActionListener(checkbox_listener);		
		checkBox_8.addActionListener(checkbox_listener);
		checkBox_9.addActionListener(checkbox_listener);		
		checkBox_10.addActionListener(checkbox_listener);
		checkBox_11.addActionListener(checkbox_listener);		
		checkBox_12.addActionListener(checkbox_listener);
		checkBox_13.addActionListener(checkbox_listener);
		checkBox_14.addActionListener(checkbox_listener);
		checkBox_15.addActionListener(checkbox_listener);
		checkBox_16.addActionListener(checkbox_listener);
		checkBox_17.addActionListener(checkbox_listener);
		checkBox_18.addActionListener(checkbox_listener);
		checkBox_19.addActionListener(checkbox_listener);
		checkBox_20.addActionListener(checkbox_listener);

		
		JLabel lblNewLabel = new JLabel("             Seats of the bus");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(130, 25, 253, 23);
		getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 240, 282, 23);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(54, 240, 52, 23);
		getContentPane().add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 280, 282, 23);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setBounds(54, 280, 66, 23);
		getContentPane().add(lblTelephone);
		
		 btnOk = new JButton("Ok");

		btnOk.setBounds(130, 313, 89, 23);
		getContentPane().add(btnOk);
		
	    btnCancel = new JButton("Cancel");
		
		btnCancel.setBounds(229, 313, 89, 23);
		getContentPane().add(btnCancel);
		
	    btnTerminate = new JButton("Terminate");

		btnTerminate.setBackground(Color.RED);
		btnTerminate.setBounds(328, 313, 89, 23);
		getContentPane().add(btnTerminate);
	}
	class ActionHandler implements ActionListener {
		int c = 0;
	    public void actionPerformed(ActionEvent event) {
	    	get_count();
	        JCheckBox cbox = (JCheckBox) event.getSource();
	        if(cbox.isSelected()) {
	        	c++;
	        	int v = Integer.valueOf(cbox.getText().toString());
	        	booked[v-1] = true;
	        }
	        else {
	        	c--;
	        	int v = Integer.valueOf(cbox.getText().toString());
	        	booked[v-1] = false;
	        }
	        Seat_booking.tracker(c);
	    }
	}
}
