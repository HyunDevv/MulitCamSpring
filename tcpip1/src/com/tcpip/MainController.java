package com.tcpip;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {
   
   Client client;
   
   public MainController() {
      client = new Client("192.168.0.103", 5555, "[WEB]");
      try {
         client.connect();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @RequestMapping("/main.mc")
   public ModelAndView main() {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("main");
      return mv;
   }
   

   @RequestMapping("/iot.mc")
   public void iot(HttpServletResponse res,HttpServletRequest request) throws IOException {
      client.sendTarget("/192.168.0.103", "100");
      String ip = request.getParameter("ip");
      if(ip != null && !ip.equals("")) {
    	  System.out.println(ip);
    	  client.sendTarget(ip, "100");
    	  System.out.println("IoT Send Start:"+ip);
      }else {
    	  System.out.println("IoT Send Start ..");
      }
      
      PrintWriter out = res.getWriter();
      out.print("ok");
      out.close();
   }

   @RequestMapping("/phone.mc")
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = null;
		try {
			url = new URL("https://fcm.googleapis.com/fcm/send");
		} catch (MalformedURLException e) {
			System.out.println("Error while creating Firebase URL | MalformedURLException");
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Error while createing connection with Firebase URL | IOException");
			e.printStackTrace();
		}
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");

		// set my firebase server key
		conn.setRequestProperty("Authorization", "key="
				+ "AAAAK89FyMY:APA91bGxNwkQC6S_QQAKbn3COepWgndhyyjynT8ZvIEarTaGpEfMA1SPFo-ReN8b9uO21R1OfSOpNhfYbQaeohKP_sKzsgVTxu7K5tmzcjEfHzlgXRFrB1r0uqhfxLp4p836lbKw_iaN");

		// create notification message into JSON format
		
		JSONObject message = new JSONObject();
		message.put("to", "/topics/car");
		message.put("priority", "high");
		
		JSONObject notification = new JSONObject();
		notification.put("title", "title1");
		notification.put("body", "body1");
		message.put("notification", notification);
		
		JSONObject data = new JSONObject();
		data.put("control", "control1");
		data.put("data", 100);
		message.put("data", data);


		try {
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(message.toString());
			out.flush();
			conn.getInputStream();
			System.out.println("OK...............");

		} catch (IOException e) {
			System.out.println("Error while writing outputstream to firebase sending to ManageApp | IOException");
			e.printStackTrace();
		}
      
      
   }
}