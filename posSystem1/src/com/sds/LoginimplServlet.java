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


@WebServlet({ "/LoginimplServlet", "/loginimpl" })
public class LoginimplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Controller<String, User> controller;

    public LoginimplServlet() {
        super();
        controller = new UserController();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// Login 처리
		// 1. ID, PWD를 받는다
		// 2. ID값이 있는지 확인한다.
		// 3. ID값이 존재하면 PWD가 동일한지 확인한다.
		// 4. 정상이면 정상 페이지로 비정상이면 비정상페이지로 이동
		
		User user = null;
		try {
			user=controller.get(id);
			if (id.equals("admin") && pwd.equals("admin")) {
				System.out.println("test1");
				response.sendRedirect("admin.jsp");
			}else if (user.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginuser", user);
				request.setAttribute("centerpage", "loginok");
				RequestDispatcher rd = 
						request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
			}else {
				System.out.println("test");
				response.sendRedirect("login.jsp");
			}
		}catch (Exception e) {
			response.sendRedirect("login.jsp");
			e.printStackTrace();
		}
		
	}

}
