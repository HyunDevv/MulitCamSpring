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

import controller.ProductController;
import frame.Controller;
import vo.Product;

/**
 * Servlet implementation class GetDataServlet4
 */
@WebServlet({ "/GetDataServlet4", "/getdata4" })
public class GetMenuData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Controller<String, Product> controller;
	
    public GetMenuData() {
        super();
        controller = new ProductController();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Product> list = new ArrayList<>();
		try {
			list = controller.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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








