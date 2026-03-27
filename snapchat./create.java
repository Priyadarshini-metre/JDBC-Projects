
package snapchat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class create {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/java3pm";
		String un = "root";
		String pw = "Priya@9924";
		String query = "insert into snapchat values (? , ?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("loaded sucesffuly");

		Connection con = DriverManager.getConnection(url, un, pw);
		System.out.println("conneted Succesfully");

		PreparedStatement pstmt = con.prepareStatement(query);

		Scanner sc = new Scanner(System.in);

		System.out.println("create username ");

		String uname = sc.nextLine();

		System.out.println("create password ");

		String pws = sc.nextLine();

		pstmt.setString(1, uname);
		pstmt.setString(2, pws);

		pstmt.executeUpdate();

		System.out.println("account created SuccesFULLY");

		pstmt.close();

		con.close();

	}

}  
