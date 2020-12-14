package com.tcpip;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chat.Client;

@Controller
public class MainController {
	
	Client client;
	
	public MainController() {
		client = new Client("192.168.0.103",5555,"[WEB]");
		try {
			client.connect();
		} catch (IOException e) {
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
	public void iot() {
		System.out.println("Iot Send Start ....");
		client.sendTarget("/192.168.0.103","100");
	}
	
	@RequestMapping("/phone.mc")
	public void phone() {
		System.out.println("Phone Send Start ....");
	}
	
}
