package test;

import java.util.ArrayList;

import controller.UserController;
import frame.Controller;
import vo.User;

public class UserSelectTest {

	public static void main(String[] args) {
		
		ArrayList<User> list = null;
		Controller<String, User> controller = new UserController();
		try {
			list = controller.get();
			for(User user:list) {
				System.out.println(user);
			}
		}catch(Exception e) {
			System.out.println("Select Fail");
			e.printStackTrace();
		}
	
	}

}
