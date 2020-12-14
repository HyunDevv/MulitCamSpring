package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.ContentsVO;

public class App {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,ContentsVO> biz = 
				(Biz)factory.getBean("cbiz");
	
		ArrayList<ContentsVO> list = null;
		HashMap<String, Integer> smap = new HashMap<>();
		smap.put("start",20);
		smap.put("end",30);
		try {
			list = biz.search(smap);
			for(ContentsVO cv:list) {
				System.out.println(cv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		ContentsVO c = new ContentsVO("title3", "contents3", "JAMES3");
//		ContentsVO c1 = new ContentsVO(110, "title1", "contents1");
//
//		try {
//			System.out.println(biz.get(110));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			biz.register(c);
//			System.out.println("register OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			biz.modify(c1);
//			System.out.println("modify OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			biz.remove(1);
//			System.out.println("remove OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			ArrayList<ContentsVO> list = null;
//			list = biz.get();
//			for(ContentsVO it:list) {
//			System.out.println(it);
//			}
//			System.out.println("get OK");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		factory.close();
		System.out.println("Spring End .......");
		System.out.println("App End .......");

	}

}
