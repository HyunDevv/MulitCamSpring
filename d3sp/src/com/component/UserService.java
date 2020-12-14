package com.component;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.frame.Search;
import com.frame.Service;
import com.mapper.UserMapper;
import com.vo.User;
@org.springframework.stereotype.Service("userservice")
public class UserService implements Service<String, User>,Search<String, String, User> {
	
	@Autowired
	UserMapper dao;
	
	//@Resource(name="userdao")
	Search search;
	
	@Override
	public void register(User v) throws Exception{
		System.out.println("Log Start..."+v.getId());
		dao.insert(v);
		System.out.println("Log End..."+v.getId());
	}

	@Override
	public void remove(String k) throws Exception{
		dao.delete(k);
	}

	@Override
	public void modify(User v) throws Exception{
		dao.update(v);
	}

	@Override
	public User get(String k) throws Exception{
		return (User) dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception{
		return dao.selectall();
	}

	@Override
	public ArrayList<User> search(String k1) throws Exception {
		return search.search(k1);
	}

	@Override
	public ArrayList<User> search(String k1, String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

