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
			int result = pstmt.executeUpdate();	//sql 적용
			if(result == 0) {
				throw new Exception();	//없는값 지우려고 할때
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
			pstmt.executeUpdate();	//적용
		} catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}

	@Override
	public User select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//변수 초기화
		User user = null;
		try {
			//con = getConnection();	//연결 시작
			pstmt = con.prepareStatement(Sql.userSelect);//sql문 생성
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();//쿼리문실행결과를 rset에 저장
			rset.next(); //결과를 내려가며 읽어들인다
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD"); //결과에서 ID값 가져오기
				String name = rset.getString("NAME"); 
				user = new User(id, pwd, name);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			//close(con);//연결 종료(반드시실행)
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		ArrayList<User> list = new ArrayList<>();//리턴할 리스트 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;	//변수 초기화
		try {
			//con = getConnection();	//연결 시작
			pstmt = con.prepareStatement(Sql.userSelectAll);//sql문 생성
			rset = pstmt.executeQuery();//쿼리문실행결과를 rset에 저장
			while(rset.next()) {//결과를 내려가며 읽어들인다
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD"); //결과에서 ID값 가져오기
				String name = rset.getString("NAME"); 
				User pd = new User(id, pwd, name);
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
