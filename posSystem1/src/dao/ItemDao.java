package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.Item;

public class ItemDao extends Dao<Integer, Item> {

	@Override
	public void insert(Connection con, Item v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.itemInsert);
			pstmt.setString(1,v.getName());
			pstmt.setInt(2,v.getPrice());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}		
	}

	@Override
	public void delete(Connection con, Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, Item v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item select(Connection con, Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Item> select(Connection con) throws Exception {
		ArrayList<Item> list = new ArrayList<>();//리턴할 리스트 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//변수 초기화
		try {
			//con = getConnection();	//연결 시작
			pstmt = con.prepareStatement(Sql.itemSelectAll);//sql문 생성
			rset = pstmt.executeQuery();//쿼리문실행결과를 rset에 저장
			while(rset.next()) {//결과를 내려가며 읽어들인다
				int id = rset.getInt("ID");
				int price = rset.getInt("PRICE"); //결과에서 ID값 가져오기
				String name = rset.getString("NAME"); 
				Date regdate = rset.getDate("REGDATE");
				Item pd = new Item(id, name, price, regdate);
				list.add(pd);	//리스트에 결과 객체 저장
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			//close(con);//연결 종료(반드시실행)
		}
		return list;
	}

}
