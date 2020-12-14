package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ShopVO;
import com.vo.UserVO;

public class App3 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,ShopVO> biz = 
				(Biz)factory.getBean("sbiz");
	
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
		
		
		ShopVO s = new ShopVO("¹°°Ç1", 10000, "pants.jpg");


		try {
			biz.register(s);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			biz.register(u);
//			System.out.println("register OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
			ShopVO s1 = new ShopVO(); 
			s1 = biz.get(100);
			System.out.println(s1);
			System.out.println("get ok");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ArrayList<ShopVO> list = null;
			list = biz.get();
			for(ShopVO it:list) {
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
