package hive;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChartController {

	String url = "jdbc:hive2://192.168.111.120:10000/default";
	String id = "root";
	String password = "111111";

	public ChartController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getdata1.mc")
	@ResponseBody
	public void getdata1(HttpServletResponse res) throws IOException, SQLException {
		
		Connection con = null;
		JSONArray ja = new JSONArray();
		
		try {
			con = DriverManager.getConnection(url,id,password);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM hdi LIMIT 10");
			ResultSet rset = pstmt.executeQuery();
	
			// [ {name: '' , data:[ , , ]} ,{}]
			
			while(rset.next()) {
					
				JSONObject jo = new JSONObject();
				jo.put("name", rset.getString(2));
				JSONArray jo2 = new JSONArray();
				jo2.add(rset.getFloat(3));
				jo2.add(rset.getFloat(4));
				jo2.add(rset.getFloat(5));
				jo.put("data", jo2);

				ja.add(jo);
				
			}
			
		}catch(Exception e) {
			throw e;
		}finally {
			con.close();
		}
		

		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();

	}
	
	
	
	@RequestMapping("/getdata2.mc")
	@ResponseBody
	public void getdata2(HttpServletResponse res) throws IOException, SQLException {
		
		Connection con = null;
		JSONArray ja = new JSONArray();
		
		try {
			con = DriverManager.getConnection(url,id,password);
			PreparedStatement pstmt = con.prepareStatement("SELECT coronadate, COUNT(num) AS SUM FROM seoulcorona GROUP BY coronadate ORDER BY coronadate DESC LIMIT 10");
			ResultSet rset = pstmt.executeQuery();
	
			// [ {name: '' , data:[ , , ]} ,{}]
			JSONObject jo = new JSONObject();
			JSONArray ja2 = new JSONArray();
			jo.put("name", "¼­¿ï½Ã");
			
			while(rset.next()) {
					
				ja2.add(rset.getInt(2));
				
			}
			jo.put("data", ja2);
			ja.add(jo);
			
		}catch(Exception e) {
			throw e;
		}finally {
			con.close();
		}
		

		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();

	}

}
