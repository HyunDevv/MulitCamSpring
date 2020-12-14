package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BurgerStockDao;
import dao.ProductDao;
import dao.UserDao;
import dao.UserItemDao;
import frame.Controller;
import frame.Dao;
import vo.BurgerStock;
import vo.Product;
import vo.User;
import vo.UserItem;

public class BurgerStockController extends Controller<String, BurgerStock> {

	Dao<String,BurgerStock> dao;
	
	public BurgerStockController() {
		dao = new BurgerStockDao();
	}
	
	@Override
	public void register(BurgerStock v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.insert(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void remove(String k) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.delete(con, k);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void modify(BurgerStock v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.update(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public BurgerStock get(String k) throws Exception {
		BurgerStock burgerStock = null;
		Connection con = null;
		
		try {
			con = getConnection();
			burgerStock = dao.select(con,k);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return burgerStock;
	}

	@Override
	public ArrayList<BurgerStock> get() throws Exception {
		ArrayList<BurgerStock> list = null;
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
