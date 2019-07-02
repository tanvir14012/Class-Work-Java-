package mypack;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

public class Trigger {
	public static java.sql.Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static int numRows;
	public static ArrayList<String[]> ans1;
	public static ArrayList<String[]> makeConnection(String id, int salary) {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			 con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:mydb","system","tanvir");  
			  
			//step3 create the statement object  
			 stmt=con.createStatement();  
			 if(id.equals("-147")) {
			rs = stmt.executeQuery("select * from myaudit");
			
			ResultSetMetaData data = rs.getMetaData();
			 numRows = data.getColumnCount();
			 ans1= new ArrayList<String[]>();
			  String[] ans = new String[data.getColumnCount()];
			  for(int i = 0; i<data.getColumnCount(); i++){
				  ans[i]=(data.getColumnName(i+1).toString());
			  }
			  ans1.add(ans);
	
			  while(rs.next()) {
				  ans = new String[data.getColumnCount()];
				  for(int i = 0; i<data.getColumnCount(); i++) {
					  ans[i]=(rs.getObject(i+1).toString());
					  System.out.println(rs.getObject(i+1).toString() + " ");
				  }
				  System.out.println("\n");
				  ans1.add(ans);
			  }
			  
			 }
			 else {
				 stmt.executeQuery(String.format("update employee set salary = %d where id = '%s' ", salary,id));
			 }
			  //step5 close the connection object  
			con.close();  
	
			}catch(Exception e){ System.out.println(e);} 
		return ans1;
	}
}
