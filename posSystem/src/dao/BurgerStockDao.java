package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.BurgerStock;
import vo.Item;
import vo.Product;
import vo.User;

public class BurgerStockDao extends Dao<String, BurgerStock> {

	@Override
	public void insert(Connection con, BurgerStock v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.bsInsert);
			pstmt.setString(1,v.getName());
			pstmt.setInt(2,v.getStock());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}

	@Override
	public void delete(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.bsDelete);
			pstmt.setString(1,k);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}

	@Override
	public void update(Connection con, BurgerStock v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.bsUpdate);
			pstmt.setInt(1,v.getStock());
			pstmt.setString(2,v.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}

	@Override
	public BurgerStock select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BurgerStock burgerStock = null;
		try {
			pstmt = con.prepareStatement(Sql.bsSelect);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			String name = rset.getString("ID");
			int stock = rset.getInt("STOCK");
			burgerStock = new BurgerStock(name,stock);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return burgerStock;
	}

	@Override
	public ArrayList<BurgerStock> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BurgerStock> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(Sql.bsSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String name = rset.getString("NAME");
				int stock = rset.getInt("STOCK");
				BurgerStock burgerStock = new BurgerStock(name,stock);
				list.add(burgerStock);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}






