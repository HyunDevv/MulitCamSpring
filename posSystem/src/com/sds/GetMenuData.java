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
 * Servlet implementation class GetDataServlet4
 */
@WebServlet({ "/GetDataServlet4", "/getdata4" })
public class GetMenuData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("001", "버거1", 5500, "11.jpg"));
		list.add(new Product("002", "치즈버거", 4500, "22.jpg"));
		list.add(new Product("003", "베이컨치즈버거", 6000, "33.jpg"));
		list.add(new Product("004", "빅맥", 7000, "44.jpg"));
		list.add(new Product("005", "맥스파이시", 5000, "55.jpg"));
		list.add(new Product("006", "더블패티버거", 5500, "66.jpg"));
		list.add(new Product("007", "버거2", 6000, "77.jpg"));
		list.add(new Product("008", "새우버거", 4500, "88.jpg"));
		list.add(new Product("009", "수제버거", 9000, "99.jpg"));
		list.add(new Product("010", "쉑쉑버거", 15000, "100.jpg"));


		JSONArray ja = new JSONArray();
		for(Product p:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("price", p.getPrice());
			obj.put("img", p.getImg());
			ja.add(obj);
		}

		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());

	}
}








