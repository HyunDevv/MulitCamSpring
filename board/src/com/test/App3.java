package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.BoardVO;

public class App3 {

	public static void main(String[] args) {
		System.out.println("App Start .......");
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started .......");
		// IoC
		
		Biz<Integer,BoardVO> biz = 
				(Biz)factory.getBean("bbiz");
	
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
		
		
		BoardVO b = new BoardVO("title1", "content1", "writer1");


		try {
			biz.register(b);
			System.out.println("register OK");
		} catch (Exception e) {
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
			BoardVO board = new BoardVO(); 
			board = biz.get(1);
			System.out.println(board);
			System.out.println("get ok");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ArrayList<BoardVO> list = null;
			list = biz.get();
			for(BoardVO it:list) {
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
