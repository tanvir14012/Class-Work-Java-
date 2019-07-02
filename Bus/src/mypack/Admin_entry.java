package mypack;

import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;

public class Admin_entry extends JFrame{
	private boolean set = false;
	
	public Admin_entry() {
		super("Admin area");
	}
	public void make_trip(String bus_no,String from,String to, 
	String date,String time, int seats) {
		save( bus_no,from,to, date,time,seats);
		set = true;
	}
	
	public void save(String bus_no,String from,String to, 
	String date,String time, int seats) {
		try{
		FileOutputStream fout = new FileOutputStream("admin.txt");
		PrintStream p = new PrintStream(fout);
		p.println(bus_no);
		p.println(from);
		p.println(to);
		p.println(date);
		p.println(time);
		p.println(seats);
		p.close();
		fout.close();
		
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	public boolean is_set() {
		return set;
	}
	

}
