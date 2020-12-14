package com.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Db;
import com.frame.Sql;
import com.vo.Product;

public class ProductDb extends Db<Integer, Product> { // 제너릭에서는 PRIMITIVE TYPE을 설정할때는 래퍼클래스를 사용한다

	public ProductDb() {
		super();
	}

	public ProductDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

	@Override
	public void insert(Product v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productInsert);
			pstmt.setInt(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(Integer k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productDelete);
			pstmt.setInt(1, k);
			int result = pstmt.executeUpdate(); // 지우려는 값이 없으면 강제로 EXCEPTION을 만들어서 보낸다.
			System.out.println(result);
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(Product v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productUpdate);
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setDouble(3, v.getRate());
			pstmt.setInt(4, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public Product select(Integer k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productSelect);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery(); // 가져올때 EXECUTEqUERY사용
			rset.next();
			int id = rset.getInt("ID"); // ""안에는 컬럼 명
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			double rate = rset.getDouble("RATE");
			Date regdate = rset.getDate("REGDATE");
			product = new Product(id, name, price, rate, regdate);
		} catch (Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return product;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productSelectAll);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				double rate = rset.getDouble("RATE");
				Date regdate = rset.getDate("REGDATE");
				product = new Product(id, name, price, rate,regdate);
				list.add(product);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return list;
	}

}