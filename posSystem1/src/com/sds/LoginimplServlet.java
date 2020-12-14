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

		// Login ó��
		// 1. ID, PWD�� �޴´�
		// 2. ID���� �ִ��� Ȯ���Ѵ�.
		// 3. ID���� �����ϸ� PWD�� �������� Ȯ���Ѵ�.
		// 4. �����̸� ���� �������� �������̸� �������������� �̵�
		
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
