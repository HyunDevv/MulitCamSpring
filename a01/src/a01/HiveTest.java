package a01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class HiveTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:hive2://192.168.111.120:10000/default";
		String id = "root"; 
		String password = "111111";
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection con = DriverManager.getConnection(url,id,password);
		PreparedStatement pstmt = con.prepareStatement("SELECT coronadate, COUNT(num) AS SUM FROM seoulcorona GROUP BY coronadate ORDER BY coronadate DESC LIMIT 10");
		ResultSet rset = pstmt.executeQuery();
		
		JSONArray ja = new JSONArray();
		
		// [ {name: '' , data:[ , , ]} ,{}]
		
		JSONObject jo = new JSONObject();
		JSONArray ja2 = new JSONArray();
		jo.put("name", "È®ÁøÀÚ");
		
		while(rset.next()) {
//			String s1 = rset.getString(2);
//			float s2 = rset.getFloat(3);
//			float s3 = rset.getFloat(4);
//			float s4 = rset.getFloat(5);
//			System.out.println(s1+" "+s2+" "+s3+" "+s4);	
	
			
			ja2.add(rset.getInt(2));
			

			
		}
		jo.put("data", ja2);
		ja.add(jo);
		
		
		
		System.out.println(ja.toJSONString());		
		con.close();
	}

}
