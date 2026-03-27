package snapchat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/java3pm";
		String un = "root";
		String pw = "Priya@9924";
		String query = "select * from snapchat  where username = ? and spassword = ?" ;
 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loaded sucesffuly");
		
	    Connection con =	DriverManager.getConnection(url, un, pw);
		System.out.println("conneted Succesfully");
		
		
		PreparedStatement pstmt =    con.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("enter username ");

		String uname = sc.nextLine();

		System.out.println("enter password ");

		String pws = sc.nextLine();
		

		pstmt.setString(1, uname);
		pstmt.setString(2, pws);


		
		 ResultSet  res  = pstmt.executeQuery();
		 
		 
		 if(res.next())
		 {
			 System.out.println("log in succesFull");
	 
		 }
		 else{
			 System.out.println("invaild cer");
		 }
		 
		 
		 pstmt.close();
		 
		 con.close();
		 
	}
		 

}
