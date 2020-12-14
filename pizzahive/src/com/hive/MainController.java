package com.hive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.MemberVO;

@Controller
public class MainController {

	@Resource(name = "mbiz")
	Biz<String, MemberVO> mbiz;

	@RequestMapping("/login.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}

	// �α��� ����
	@RequestMapping("/loginimpl.mc") // alert ����� ���� HttpServletResponse response �߰�
	public ModelAndView loginimpl(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVO dbuser = null;

		// spring���� alert�� �ϴ� ����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println(id+pwd);
		
		if (id.equals("admin") && pwd.equals("admin")) {
			mv.setViewName("admin");
			return mv;
		} else {
			try {
				dbuser = mbiz.get(id);
				if (dbuser.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("loginuser", dbuser);
					mv.setViewName("main");
				} else { // password ���� ��
					mv.setViewName("login");
					// spring���� alert�� �ϴ� ����----------------------------------
					out.println("<script>alert('�α��ο� �����Ͽ����ϴ�'); </script>");
					out.flush();
					// ---------------------------------------------------------
					return mv;
				}
			} catch (Exception e) {
				mv.setViewName("login");
				out.println("<script>alert('�α��� �����Դϴ�'); </script>");
				out.flush();
				e.printStackTrace();
			}

		}
		return mv;
	}

	@RequestMapping("/logout.mc")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		mv.setViewName("main");
		return mv;
	}

}
