package com.sds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import controller.BurgerStockController;
import frame.Controller;
import vo.BurgerStock;

/**
 * Servlet implementation class ChangeStockServlet
 */
@WebServlet({ "/ChangeStockServlet", "/changestock" })
public class ChangeStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Controller<String, BurgerStock> controller;
	
    public ChangeStockServlet() {
        super();
        controller = new BurgerStockController();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String[] stockdata = request.getParameterValues("stockdata");
		System.out.println(Arrays.toString(stockdata));
		
		BurgerStock bs = null;
		
		for(int i=0; i<stockdata.length;i++) {
			try {
				bs = controller.get(stockdata[i]);
				bs.setStock(bs.getStock() - 1);
				controller.modify(bs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
