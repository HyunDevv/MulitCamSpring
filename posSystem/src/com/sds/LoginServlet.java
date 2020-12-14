package com.sds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		System.out.println(id+" "+pw+" ");
		
		if(id.equals("admin")) {
			response.sendRedirect("admin.html");
		}else {
			response.sendRedirect("pos.html");
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
