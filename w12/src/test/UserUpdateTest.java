package test;

import controller.UserController;
import frame.Controller;
import vo.User;

public class UserUpdateTest {

	public static void main(String[] args) {
		User u = new User("id23", "pwd23", "Á¶¸»¼÷");
		Controller<String, User> controller = 
				new UserController();
		try {
			controller.register(u);
			System.out.println("Update OK");
		} catch (Exception e) {
			System.out.println("Update Fail");
			e.printStackTrace();
		}
	}

}


