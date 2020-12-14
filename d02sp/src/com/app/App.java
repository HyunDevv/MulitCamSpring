package com.app;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Search;
import com.frame.Service;
import com.vo.Item;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		
		System.out.println("App Start....");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("myspring.xml");
		System.out.println("Spring Started");

		// IoC

		Service service = (Service)factory.getBean("userservice");
	
		User user = new User("id58", "pwd58", "name");
		try {
			service.register(user);
			System.out.println("OK1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			service.remove("123");
			System.out.println("OK2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user = (User) service.get("id33");
			System.out.println("OK3"+user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			ArrayList<User> list = null;
			list = service.get();
			System.out.println("OK4");
			for(User it:list) {
				System.out.println(it);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Service service2 = (Service)factory.getBean("itemservice");
		
		Item item = new Item(123, "Ä®3", 10000);
		try {
			service2.register(item);
			System.out.println("OK11");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			service2.remove(109);
			System.out.println("OK22");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			item = (Item) service2.get(100);
			System.out.println("OK33"+item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			ArrayList<Item> list = null;
			list = service2.get();
			System.out.println("OK44");
			for(Item it:list) {
				System.out.println(it);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Search service3 = (Search)factory.getBean("userservice");
//		ArrayList<Item> list3 = null;
//		try {
//			list3 = service3.search("ÀÚ");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(Item it : list3) {
//			System.out.println(it);
//		}
		
		
		
		factory.close();
		System.out.println("Spring End...");
		System.out.println("App End...");

	}

}
