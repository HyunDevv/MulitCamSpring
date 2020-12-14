package com.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.BoardVO;
@Service("bbiz")
public class BoardBiz implements Biz<Integer, BoardVO> {

	@Resource(name="bdao")
	Dao<Integer, BoardVO> dao;
	
	
	@Override
	public void register(BoardVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		int result = 0;
		result = dao.delete(k);
		if(result ==0) {
			throw new Exception();
		}
		
	}

	@Override
	public void modify(BoardVO v) throws Exception {
		int result = 0;
		result = dao.update(v);
		if(result ==0) {
			throw new Exception();
		}
		
	}

	@Override
	public BoardVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<BoardVO> get() throws Exception {
		return dao.selectall();
	}

}
