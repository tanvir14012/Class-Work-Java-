package mypack;

import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class Connect {
	public static java.sql.Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	public static int numRows;
	public static ArrayList<String[]> ans1;
	public static ArrayList<String[]> makeConnection(String id, String dept) {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			 con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:mydb","system","tanvir");  
			  
			//step3 create the statement object  
			 stmt=con.createStatement();  
			  
			//step4 execute query  
			 CallableStatement callableStatement = con.prepareCall("{call show_info(?,?,?,?,?,?)}");
			 if(! id.equals("")){callableStatement.setString(1,id);}
			 else {
				 System.out.println("$$$$$$$");
				 callableStatement.setNull(1,java.sql.Types.VARCHAR); 
			 }
			 callableStatement.setNull(2,java.sql.Types.VARCHAR);
			 if(!dept.equals("")) {
			 callableStatement.setString(3,dept);}
			 else {
				 callableStatement.setNull(3,java.sql.Types.VARCHAR); 
			 }
			 callableStatement.setNull(4,java.sql.Types.NUMERIC);
			 callableStatement.setNull(5,java.sql.Types.VARCHAR);
			 callableStatement.registerOutParameter(6, OracleTypes.CURSOR);
			 callableStatement.execute();
			  rs = (ResultSet) callableStatement.getObject(6);
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
			  
			  //step5 close the connection object  
			con.close();  
	
			}catch(Exception e){ System.out.println(e);} 
		return ans1;
	}

}
