package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.UserVO;

public class App2 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<String,UserVO> biz = 
				(Biz)factory.getBean("ubiz");
	
//		ArrayList<UserVO> list = null;
//		HashMap<String, Integer> smap = new HashMap<>();
//		smap.put("start",20);
//		smap.put("end",30);
//		try {
//			list = biz.search(smap);
//			for(ContentsVO cv:list) {
//				System.out.println(cv);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		UserVO u = new UserVO("id01", "pwd01", "JAMES");
		UserVO u1 = new UserVO("id02", "pwd222", "JAMES222");


		try {
			biz.register(u);
			System.out.println("register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(biz.get("id01"));
			System.out.println("get OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
//		try {
//			biz.modify(u1);
//			System.out.println("modify OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			biz.remove("id35");
//			System.out.println("remove OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			ArrayList<UserVO> list = null;
			list = biz.get();
			for(UserVO it:list) {
			System.out.println(it);
			}
			System.out.println("getall OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
