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
		ArrayList<Item> list = new ArrayList<>();//������ ����Ʈ ����
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//���� �ʱ�ȭ
		try {
			//con = getConnection();	//���� ����
			pstmt = con.prepareStatement(Sql.itemSelectAll);//sql�� ����
			rset = pstmt.executeQuery();//�������������� rset�� ����
			while(rset.next()) {//����� �������� �о���δ�
				int id = rset.getInt("ID");
				int price = rset.getInt("PRICE"); //������� ID�� ��������
				String name = rset.getString("NAME"); 
				Date regdate = rset.getDate("REGDATE");
				Item pd = new Item(id, name, price, regdate);
				list.add(pd);	//����Ʈ�� ��� ��ü ����
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			//close(con);//���� ����(�ݵ�ý���)
		}
		return list;
	}

}
