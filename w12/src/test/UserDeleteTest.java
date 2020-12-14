package test;

import controller.UserController;
import frame.Controller;
import vo.User;

public class UserDeleteTest {

	public static void main(String[] args) {
		Controller<String, User> controller = 
				new UserController();
		try {
			controller.remove("id22");
			System.out.println("Delete OK");
		} catch (Exception e) {
			System.out.println("Delete Fail");
			e.printStackTrace();
		}
	}

}


