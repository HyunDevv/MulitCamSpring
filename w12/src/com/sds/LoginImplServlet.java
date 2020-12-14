package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserController;
import frame.Controller;
import vo.User;

@WebServlet({ "/LoginImplServlet", "/loginimpl" })
public class LoginImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Controller<String, User> controller;
	
    public LoginImplServlet() {
        super();
        controller = new UserController();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//DB Matching
		User user = null;
		try {
			user = controller.get(id);
			if(user.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("suserid", id);
				request.setAttribute("loginid", id);
				request.setAttribute("centerpage", "loginok");
			}else {
				request.setAttribute("centerpage", "loginfail");
			}
		}catch (Exception e1) {
			e1.printStackTrace();
			request.setAttribute("centerpage", "loginfail");
		}
		
		RequestDispatcher rd = 
		request.getRequestDispatcher("main.jsp"); 
		rd.forward(request, response);
		
	}

}




