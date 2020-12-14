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
 * Servlet implementation class GetDataServlet44
 */
@WebServlet({ "/GetDataServlet44", "/getdata44" })
public class GetDataServlet44 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1.DB에서 데이터를 가져온다
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "이말숙"));
		list.add(new User("id02", "pwd02", "김말숙"));
		list.add(new User("id03", "pwd03", "정말숙"));
		list.add(new User("id04", "pwd04", "장말숙"));
		list.add(new User("id05", "pwd05", "고말숙"));
		
			var datas = [{
        name: 'Installation',
        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
    }, {
        name: 'Manufacturing',
        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
    }, {
        name: 'Sales & Distribution',
        data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
    }, {
        name: 'Project Development',
        data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
    }, {
        name: 'Other',
        data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
    }]; 
	
		// 2.JSON으로 만든다. // 라이브러리 탑재 필수!
//		JSONArray ja = new JSONArray();
//		JSONObject jo1 = new JSONObject();
//		
//		jo1.put("id", "id01");
//		jo1.put("pwd", "pwd01");
//		jo1.put("name", "이말숙"); //[{}]
//		ja.add(jo1); // [{}]
		
		JSONArray ja = new JSONArray();
		for(User u:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", u.getId());
			obj.put("pwd", u.getPwd());
			obj.put("name", u.getName());
			ja.add(obj);
		}
		
		
		// 3. JSON 데이터를 Response 한다.
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}