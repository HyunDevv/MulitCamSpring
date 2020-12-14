package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ContentsDao;
import com.frame.Biz;
import com.frame.Dao;
import com.vo.ContentsVO;
@Service("cbiz")
public class ContentsBiz implements Biz<Integer, ContentsVO> {

	@Autowired
	ContentsDao dao;
	
	@Override
	public void register(ContentsVO v) throws Exception {
		int result = dao.insert(v);
		if(result == 0) {
			throw new Exception();
		}
	}

	@Override
	public void remove(Integer k) throws Exception {
		int result = dao.delete(k);
		if(result == 0) {
			throw new Exception();
		}
		
		
	}
	
	@Transactional
	@Override
	public void modify(ContentsVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public ContentsVO get(Integer k) throws Exception {
		dao.setcnt(k);
		return dao.select(k);
	}

	@Override
	public ArrayList<ContentsVO> get() throws Exception {
		return dao.selectall();
	}

	@Override
	public ArrayList<ContentsVO> search(Object obj) throws Exception {
		return dao.search(obj);
	}

}
