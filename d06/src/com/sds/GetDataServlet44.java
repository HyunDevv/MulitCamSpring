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

		// 1.DB���� �����͸� �����´�
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "�̸���"));
		list.add(new User("id02", "pwd02", "�踻��"));
		list.add(new User("id03", "pwd03", "������"));
		list.add(new User("id04", "pwd04", "�帻��"));
		list.add(new User("id05", "pwd05", "����"));
		
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
	
		// 2.JSON���� �����. // ���̺귯�� ž�� �ʼ�!
//		JSONArray ja = new JSONArray();
//		JSONObject jo1 = new JSONObject();
//		
//		jo1.put("id", "id01");
//		jo1.put("pwd", "pwd01");
//		jo1.put("name", "�̸���"); //[{}]
//		ja.add(jo1); // [{}]
		
		JSONArray ja = new JSONArray();
		for(User u:list) {
			JSONObject obj = new JSONObject();
			obj.put("id", u.getId());
			obj.put("pwd", u.getPwd());
			obj.put("name", u.getName());
			ja.add(obj);
		}
		
		
		// 3. JSON �����͸� Response �Ѵ�.
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}

}