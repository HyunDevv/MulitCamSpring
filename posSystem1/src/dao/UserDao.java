package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.Item;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(Connection con, User v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.userInsert);
			pstmt.setString(1,v.getId());
			pstmt.setString(2,v.getPwd());
			pstmt.setString(3,v.getName());
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
			pstmt = con.prepareStatement(Sql.userDelete);
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();	//sql ����
			if(result == 0) {
				throw new Exception();	//���°� ������� �Ҷ�
			}
		} catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
		
	}

	@Override
	public void update(Connection con, User v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.userUpdate);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();	//����
		} catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}

	@Override
	public User select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//���� �ʱ�ȭ
		User user = null;
		try {
			//con = getConnection();	//���� ����
			pstmt = con.prepareStatement(Sql.userSelect);//sql�� ����
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();//�������������� rset�� ����
			rset.next(); //����� �������� �о���δ�
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD"); //������� ID�� ��������
				String name = rset.getString("NAME"); 
				user = new User(id, pwd, name);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			//close(con);//���� ����(�ݵ�ý���)
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		ArrayList<User> list = new ArrayList<>();//������ ����Ʈ ����
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//���� �ʱ�ȭ
		try {
			//con = getConnection();	//���� ����
			pstmt = con.prepareStatement(Sql.userSelectAll);//sql�� ����
			rset = pstmt.executeQuery();//�������������� rset�� ����
			while(rset.next()) {//����� �������� �о���δ�
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD"); //������� ID�� ��������
				String name = rset.getString("NAME"); 
				User pd = new User(id, pwd, name);
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
