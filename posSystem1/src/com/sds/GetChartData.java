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
 * Servlet implementation class GetDataServlet3
 */
@WebServlet({ "/GetDataServlet3", "/getdata3" })
public class GetChartData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.DB���� �����͸� ������´�.
		ArrayList<Price> list = new ArrayList<>();


		int[] data1 = {4000, 5000, 4500, 7000, 8000, 5500, 6000, 5500, 7000};
		list.add(new Price("���", data1));
		int data2[] = {5000, 3000, 4500, 6000, 4000, 6000, 8000, 9000, 4500};
		list.add(new Price("ġ�����", data2));

		//2.JSON���� �����.

		JSONArray ja = new JSONArray();
		for(Price p:list) {
			JSONObject obj = new JSONObject();

			JSONArray ja2 = new JSONArray();
			for(int i=0;i<p.getData().length;i++) {
				int[] arr = new int[9];
				ja2.add(p.getData()[i]);
			}
			obj.put("data", ja2);
			obj.put("name", p.getName());
			ja.add(obj);
		}

		//3. JSON �����͸� Response�Ѵ�.

		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());

	}

}
