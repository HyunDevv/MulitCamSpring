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
 * Servlet implementation class GetDataServlet
 */
@WebServlet({ "/GetDataServlet", "/getdatas" })
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd"); //�������� �λ����� �޾ƿ´�
		
		ArrayList<Branch> list = new ArrayList<>();

		list.add(new Branch("�ؼ���â����", 'B', 35.1662052, 129.1461986));
		list.add(new Branch("�ؼ���â����Ƽ��", 'B', 35.1662027, 129.1461128));
		list.add(new Branch("�ؼ���â������", 'B', 35.1695029,129.1327232));
		list.add(new Branch("�ؼ���â������", 'B', 35.154276,129.0384618));
		
		list.add(new Branch("��������", 'B', 37.5708508,126.9743569));
		list.add(new Branch("�������", 'B', 37.5701527,126.9971464));
		list.add(new Branch("�踲�ߵ�����", 'B', 37.5701523,126.9905535));
		list.add(new Branch("�������â", 'B', 37.5719819,126.9786982));
		
		
		JSONArray ja = new JSONArray();
		for (Branch u : list) {
			JSONObject obj = new JSONObject();
			obj.put("title", u.getTitle());
			obj.put("city", u.getCity()+"");
			obj.put("lat", u.getLat());
			obj.put("lng", u.getLng());
			ja.add(obj);
		}

		// 3. JSON �����͸� Response �Ѵ�.
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	    System.out.println(ja.toJSONString());
	}

}
