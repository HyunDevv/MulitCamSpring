package a01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mariadb://192.168.111.102:3306/shopdb";
		String id = "wuser"; 
		String password = "111111";
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,id,password);
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM items");
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			String did = rset.getString("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			System.out.println(did+" "+name+" "+price);					
		}
		con.close();
	}

}
