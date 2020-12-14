package com.biz;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.frame.Biz;
import com.vo.UserVO;

@Service("ubiz")
public class UserBiz implements Biz<String, UserVO> {

	@Autowired
	UserDao dao;
	
	@Override
	public void register(UserVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		int result = dao.delete(k);
		if(result == 0) {
			throw new Exception();
		}
		
	}

	@Override
	public void modify(UserVO v) throws Exception {
		int result = dao.update(v);
		if(result == 0) {
			throw new Exception();
		}
	}

	@Override
	public UserVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public ArrayList<UserVO> search(Object obj) throws Exception {
		return dao.search(obj);
	}

}
