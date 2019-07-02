package mypack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Salesman_entry {
	private static String from;
	private static String to;
	private static String time;
	private static int seats;
	private static boolean[] booked;
	

	public static void update(boolean[] b) {
		for(int i=0; i<b.length; i++) {
			booked[i]  = b[i];
		}
		try {
			FileOutputStream fout = new FileOutputStream("inter_result.txt");
			PrintStream p = new PrintStream(fout);
			for(int i = 0; i<booked.length ;i++) {
				p.println(booked[i]);
			}
			p.close();
			fout.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	public static void load_inter_result() {
		load();
		try {
			File f = new File("inter_result.txt");
			Scanner cin = new Scanner(f);
			booked = new boolean[seats];
			for(int i = 0; i<seats;i++) {
				booked[i] = cin.nextBoolean();
			}
		}catch(FileNotFoundException fex) {
			booked = new boolean[seats];
			for(int i = 0; i<seats;i++) {
				booked[i] = false;
			}
		}
		catch(Exception ex) {
			System.out.println("Maybe a file problem");
			ex.getMessage();
		}
	}
	public static boolean[] give_boolean() {
		load_inter_result();
		return booked;
	}
	public static int give_seats() {
		load();
		return seats;
	}
	public static void load() {
		
		try {
			File f = new File("admin.txt");
			Scanner cin = new Scanner(f);
			if(cin.hasNextLine()) {
				cin.nextLine();
				from = cin.nextLine();
				to = cin.nextLine();
				cin.nextLine();
				time =cin.nextLine();
			}
			if(cin.hasNextInt()){
				seats = cin.nextInt();
				if(seats < 21)
					seats = 21;
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	public void Do_transaction() {
		if(new File("admin.txt") == null) {
			JOptionPane.showMessageDialog(null, "Service Unavailable!");
			return ;
		}
		load();
			//Input source,time,destination from customer
			//search and if matches then proceed
			boolean status = Searching_journey.main_method(from,to,time);
		if(status) {
		booked = new boolean[seats];
		}
		else {
			return ;
		}
		
	}
	

}
