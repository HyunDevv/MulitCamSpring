package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDao;
import frame.Controller;
import frame.Dao;
import vo.Item;

public class ItemController extends Controller<Integer, Item> {

	Dao<Integer, Item> dao;
	
	public ItemController() {
		dao = new ItemDao();
	}
	
	@Override
	public void register(Item v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.insert(con, v);
			con.commit();	//수동커밋이기 때문에 커밋해서 적용
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}		
	}



	@Override
	public void modify(Item v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item get(Integer k) throws Exception {
		ArrayList<Item> list = null;
		Connection con = null;
		try {
			con = getConnection();
			list = dao.select(con);
			
		}catch(Exception e) {
			
		}finally {
			
		}
		return null;
	}

	@Override
	public ArrayList<Item> get() throws Exception {
		ArrayList<Item> list = null;
		Connection con = null;
		try {
			con = getConnection();
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return list;		
	}

}
