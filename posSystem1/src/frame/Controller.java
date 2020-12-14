package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Controller<K, V> {
	public Controller() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Not Found !");
		}
	}
	public Connection getConnection() {
		String user = "DB2";
		String password = "DB2";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		try {
			con  = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);	//커밋은 수동으로 하도록 설정
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not Connection !");
		}
		return con;
	}
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void register(V v) throws Exception;
	public abstract void remove(K k) throws Exception;
	public abstract void modify(V v) throws Exception;
	public abstract V get(K k) throws Exception;
	public abstract ArrayList<V> get() throws Exception;

}
