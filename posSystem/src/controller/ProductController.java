package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDao;
import dao.UserDao;
import dao.UserItemDao;
import frame.Controller;
import frame.Dao;
import vo.Product;
import vo.User;
import vo.UserItem;

public class ProductController extends Controller<String, Product> {

	Dao<String,Product> dao;
	
	public ProductController() {
		dao = new ProductDao();
	}
	
	@Override
	public void register(Product v) throws Exception {
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
	public void modify(Product v) throws Exception {
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
	public Product get(String k) throws Exception {
		Product product = null;
		Connection con = null;
		
		try {
			con = getConnection();
			product = dao.select(con,k);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return product;
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		ArrayList<Product> list = null;
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
