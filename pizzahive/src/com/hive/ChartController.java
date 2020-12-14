package com.hive;

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

	String url = "jdbc:hive2://192.168.111.130:10000/default";
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
			PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(DATELOG) FROM MEMBERS");
			ResultSet rset = pstmt.executeQuery();
	
			// [ {name: '' , data:[ , , ]} ,{}]
			JSONObject jo = new JSONObject();
			JSONArray ja2 = new JSONArray();
			jo.put("name", "ÃÑ Å¬¸¯ ¼ö");
			
			while(rset.next()) {
				System.out.println("1: " + rset.getInt(1));	
				ja2.add(rset.getInt(1));
				
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
