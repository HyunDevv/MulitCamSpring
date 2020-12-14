package com.component;

import org.springframework.stereotype.Component;

import com.frame.Dao;

@Component("mysqldao")
public class MySqlDao implements Dao {

	@Override
	public void insert() {
		System.out.println("MySql Inserted...");

	}

	@Override
	public void delete() {
		System.out.println("MySql Inserted...");

	}

	@Override
	public void update() {
		System.out.println("MySql Inserted...");

	}

}
