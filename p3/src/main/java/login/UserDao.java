package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";

	Connection con = null;

	//등록
	public void RegisterUser (User u) {

		try {
			dbCon();
			String sql = "insert into sign_up values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getN_id());
			pst.setString(2, u.getN_pw());
			pst.setString(3, u.getN_name());
			pst.setString(4, u.getN_tel());
		
			pst.executeUpdate();
			
			pst.close();
			con.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//중복확인
	public boolean duplicatedID(String id) {
		boolean result=false;
		
	
		try {
			dbCon();
			String  sql ="select decode( count(* ), 1 ,'true','false') ";
			        sql += " from sign_up where n_id=?";
			
			PreparedStatement pst  = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs  =pst.executeQuery();
			
			if( rs.next()) {
				result = Boolean.parseBoolean(rs.getString(1));
			}
			
			rs.close();
			pst.close();
			con.close();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//아이디 찾기
	public String findid(String name , String tel) {
		
		String id = null;	
		
		try {
			dbCon();	
			String sql = "select n_id";
			       sql += " from sign_up";
			       sql += " where n_name=? and n_tel =?";
			       
			PreparedStatement pst = con.prepareStatement(sql);
		
			pst.setString(1,name);
			pst.setString(2,tel);
			
			ResultSet rs = pst.executeQuery();
			
			
			
			if(rs.next()) {
				
				id = rs.getString(1);
				
			}
			rs.close();
			pst.close();
			con.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	
	}
	
	//비밀번호 찾기
		public String findpw(String id , String name , String tel) {
			
			String pw = null;	
			
			try {
				dbCon();	
				String sql = "select n_pw";
				       sql += " from sign_up";
				       sql += " where n_id=? and n_name=? and n_tel =?";
				       
				PreparedStatement pst = con.prepareStatement(sql);
			
				pst.setString(1,id);
				pst.setString(2,name);
				pst.setString(3,tel);
				
				ResultSet rs = pst.executeQuery();
				
				
				
				if(rs.next()) {
					
					pw = rs.getString(1);
					
				}
				rs.close();
				pst.close();
				con.close();			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pw;
		
		}
		
		//로그인 유효성 검사
		
		public boolean CheckLogin(String id, String pw) {
			boolean result=false;
			
			try {
				dbCon();
				String  sql ="select decode( count(* ), 1 ,'true','false') ";
				        sql += " from sign_up where n_id=? and n_pw=?";
				
				PreparedStatement pst  = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, pw);
				
				ResultSet rs  =pst.executeQuery();
				
				if( rs.next()) {
					result = Boolean.parseBoolean(rs.getString(1));
				}
				
				rs.close();
				pst.close();
				con.close();			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		
	//공통 dbcon
	private void dbCon() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
}