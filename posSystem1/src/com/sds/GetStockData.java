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

import controller.BurgerStockController;
import frame.Controller;
import vo.BurgerStock;
import vo.Product;

/**
 * Servlet implementation class GetStockData
 */
@WebServlet({ "/GetStockData", "/getstock" })
public class GetStockData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Controller<String, BurgerStock> controller;
	
    public GetStockData() {
        super();
        controller = new BurgerStockController();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BurgerStock> list = new ArrayList<>();
		try {
			list = controller.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray ja = new JSONArray();
		for(BurgerStock p:list) {
			JSONObject obj = new JSONObject();
			obj.put("name", p.getName());
			obj.put("stock", p.getStock());
			ja.add(obj);
		}

		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}
