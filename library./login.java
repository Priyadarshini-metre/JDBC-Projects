package library;

import java.sql.*;
import java.util.Scanner;

public class login {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java3pm","root","Priya@9924");

        String q = "select * from library where username=? and password=?";
        PreparedStatement ps = con.prepareStatement(q);

        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        ps.setString(1,u);
        ps.setString(2,p);

        ResultSet rs = ps.executeQuery();

        if(rs.next())
            System.out.println("Login Success");
        else
            System.out.println("Invalid Credentials");

        con.close();
    }
}
