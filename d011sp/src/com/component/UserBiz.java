package com.component;

import com.biz.Biz;

public class UserBiz implements Biz {

	public UserBiz() {
		System.out.println("UserBiz Constroctor...");
	}
	
	public void startLog() {
		System.out.println("User startLog");
	}
	
	@Override
	public void register() {
		System.out.println("UserBiz register");
	}

	@Override
	public void remove() {
		System.out.println("User remove");

	}

	@Override
	public void modify() {
		System.out.println("User modify");

	}

}
