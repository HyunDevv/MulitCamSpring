package com.hive;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.Click;
import com.frame.Biz;
import com.vo.MemberVO;

@Controller
public class PizzaController {

	@Resource(name = "mbiz")
	Biz<String, MemberVO> mbiz;
	
	@Autowired
	Click<MemberVO> click;
	 
	@RequestMapping("/pizza.mc")
	public ModelAndView shop(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		String it = req.getParameter("it");
		
		MemberVO dbuser = null;
		try {
			dbuser = mbiz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MemberVO member = new MemberVO(id, dbuser.getAge(), dbuser.getGender(), it);
		click.itemclick(member);
			
		mv.setViewName("main");
		return mv;
	}

}
