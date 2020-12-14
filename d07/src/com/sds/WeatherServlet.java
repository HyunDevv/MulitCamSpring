package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet({ "/WeatherServlet", "/weather" })
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlstr = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?serviceKey=GCKdLak3diVhCnTIjF1tEy7Jg4%2B%2BCZjtNKfXmQqAbkAYipPxWX%2Fv1mvxvUsDA6%2By9lyZDj%2FP0h%2FiCs36Mi46eg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&dataCd=ASOS&dateCd=DAY&startDt=20100101&endDt=20100601&stnIds=108&";
	    String xmlstr = getRequest(urlstr,"");
		response.setContentType("text/xml;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(xmlstr);
	}

	public static String getRequest(String url, String parameter) {

		try {

		String param = "{\"param\":\"" + parameter + "\"} ";

		// url를 인스턴스를 만든다.

		URL uri = new URL(url);

		// HttpURLConnection 인스턴스를 가져온다.

		HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

		// Web Method는 Post 타입

		connection.setRequestMethod("GET");



		// 요청한다. 200이면 정상이다.

		int code = connection.getResponseCode();

		if (code == 200) {

		// 응답 온 body 내용의 stream을 받는다.

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
