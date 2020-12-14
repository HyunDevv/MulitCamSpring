package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetData
 */
@WebServlet({ "/GetData", "/getdata" })
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd"); //서울인지 부산인지 받아온다
		
		ArrayList<Branch> list = new ArrayList<>();

		list.add(new Branch("해성막창본점", 'B', 35.1662052, 129.1461986));
		
		
		JSONArray ja = new JSONArray();
		for (Branch u : list) {
			JSONObject obj = new JSONObject();
			obj.put("title", u.getTitle());
			obj.put("city", u.getCity());
			obj.put("lat", u.getLat());
			obj.put("lng", u.getLng());
			ja.add(obj);
		}

		// 3. JSON 데이터를 Response 한다.
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	//	System.out.println(ja.toJSONString());
	}

}
