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
 * Servlet implementation class GeoServlets
 */
@WebServlet({ "/GeoServlets", "/geos" })
public class GetGeoData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		int num = Integer.parseInt(cmd);
		//붓싼
		ArrayList<Geo> list = new ArrayList<>();
		list.add(new Geo("부산1호점",35.1682152,129.1441986,"#", 1));
		list.add(new Geo("부산2호점",35.1662027,129.1461128,"#", 1));
		list.add(new Geo("부산3호점",35.1695029,129.1327232,"#", 1));
		list.add(new Geo("부산4호점",35.1672769,129.1354619,"#", 1));
		//서울
		list.add(new Geo("서울1호점",37.5708508,126.9743569,"#", 0));
		list.add(new Geo("서울2호점",37.5701527,126.9971464,"#", 0));
		list.add(new Geo("서울3호점",37.5701523,126.9905535,"#", 0));
		list.add(new Geo("서울4호점",37.5719819,126.9786982,"#", 0));


		JSONArray ja = new JSONArray();
		for(Geo p:list) {
			if(num == p.getBranchnum()) {
				JSONObject obj = new JSONObject();
				obj.put("name", p.getName());
				obj.put("lat", p.getLat());
				obj.put("lng", p.getLng());
				ja.add(obj);
			}
			
		}

		
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());

	}
}
