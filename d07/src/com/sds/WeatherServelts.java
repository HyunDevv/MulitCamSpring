package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServelts
 */
@WebServlet({ "/WeatherServelts", "/getweather" })
public class WeatherServelts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat ( "HH00");
				
		Date time = new Date();
				
		String timeDate = format1.format(time);
		String timeHour = format2.format(time);
		
		
		String urlstr = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst?serviceKey=GCKdLak3diVhCnTIjF1tEy7Jg4%2B%2BCZjtNKfXmQqAbkAYipPxWX%2Fv1mvxvUsDA6%2By9lyZDj%2FP0h%2FiCs36Mi46eg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&base_date="+timeDate+"&base_time="+timeHour+"&nx=60&ny=126&";
	    String xmlstr = getRequest(urlstr,"");
		response.setContentType("text/xml;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(xmlstr);
	}

	public static String getRequest(String url, String parameter) {

		try {

		String param = "{\"param\":\"" + parameter + "\"} ";

		// url�� �ν��Ͻ��� �����.

		URL uri = new URL(url);

		// HttpURLConnection �ν��Ͻ��� �����´�.

		HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

		// Web Method�� Post Ÿ��

		connection.setRequestMethod("GET");



		// ��û�Ѵ�. 200�̸� �����̴�.

		int code = connection.getResponseCode();

		if (code == 200) {

		// ���� �� body ������ stream�� �޴´�.

		try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

		String line;

		StringBuffer buffer = new StringBuffer();

		while ((line = input.readLine()) != null) {

		buffer.append(line);

		}

		return buffer.toString();

		}

		}

		return code + "";

		} catch (Throwable e) {

		throw new RuntimeException(e);

		}

		}
}

