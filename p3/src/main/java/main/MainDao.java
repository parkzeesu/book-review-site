package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection con = null;
	
	// 장르별 도서 개수
	public int getTotal( int code) {
		int count = 0;
		try {
			dbCon();
			String sql = "select count(*) from book where g_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, code);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	// 내림차순 페이징
	public ArrayList<Book> descgetPageBooks(int page, int g_code){
		int pageSize = 3;
		int start= (page-1)*pageSize+1;
		int end = page*pageSize;
		
		ArrayList<Book> list = new ArrayList<>();
		 try {			 
			dbCon();
			String sql="select  b_code, b_name, author, publisher, to_char(publication_date,'yyyy-mm-dd'), img, b_summary";
			       sql+=" from  ";
			       sql+=" ( ";
			       sql+=" select rownum num , b_code, b_name, author, publisher, publication_date, img, b_summary";
			       sql+=" from (select * from book where g_code = ? order by b_name DESC)";
			       sql+=" ) ";
			       sql+=" where num between ?  and ? ";
			PreparedStatement pst  =con.prepareStatement(sql);
			
			pst.setInt(1, g_code);
			pst.setInt(2, start);
			pst.setInt(3, end);
			ResultSet rs  =pst.executeQuery();
			
			while( rs.next()) {
				Book b = new Book (rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(b);
			}	
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}	 
		 return list;		
	}
	// 오름차순 페이징
	public ArrayList<Book> ascgetPageBooks(int page, int g_code){
		int pageSize = 3;
		int start= (page-1)*pageSize+1;
		int end = page*pageSize;
		
		ArrayList<Book> list = new ArrayList<>();
		 try {			 
			dbCon();
			String sql="select  b_code, b_name, author, publisher, to_char(publication_date,'yyyy-mm-dd'), img, b_summary";
			       sql+=" from  ";
			       sql+=" ( ";
			       sql+=" select rownum num , b_code, b_name, author, publisher, publication_date, img, b_summary";
			       sql+=" from (select * from book where g_code = ? order by b_name ASC)";
			       sql+=" ) ";
			       sql+=" where num between ?  and ? ";
			PreparedStatement pst  =con.prepareStatement(sql);
			
			pst.setInt(1, g_code);
			pst.setInt(2, start);
			pst.setInt(3, end);
			ResultSet rs  =pst.executeQuery();
			
			while( rs.next()) {
				Book b = new Book (rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(b);
			}	
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}	 
		 return list;		
	}
	// 페이징
	public ArrayList<Book> getPageBooks(int page, int g_code){
		int pageSize = 3;
		int start= (page-1)*pageSize+1;
		int end = page*pageSize;
		
		ArrayList<Book> list = new ArrayList<>();
		 try {			 
			dbCon();
			String sql="select  b_code, b_name, author, publisher, to_char(publication_date,'yyyy-mm-dd'), img, b_summary";
			       sql+=" from  ";
			       sql+=" ( ";
			       sql+=" select rownum num , b_code, b_name, author, publisher, publication_date, img, b_summary";
			       sql+=" from book where g_code = ?";
			       sql+=" ) ";
			       sql+=" where num between ?  and ? ";
			PreparedStatement pst  =con.prepareStatement(sql);
			
			pst.setInt(1, g_code);
			pst.setInt(2, start);
			pst.setInt(3, end);
			ResultSet rs  =pst.executeQuery();
			
			while( rs.next()) {
				Book b = new Book (rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(b);
			}	
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}	 
		 return list;		
	}
	// 장르코드별 장르 이름 가져오기
	public Genre genrename(int g_code){
		Genre g = null;
		try {
			dbCon();
			String sql = "select g_name from genre where g_code = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, g_code);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				g = new Genre(rs.getString(1));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	// 장르코드, 장르명 가져오기
	public ArrayList<Genre> genrelist(){
		ArrayList<Genre> list = new ArrayList<>();
		try {
			dbCon();
			Statement st = con.createStatement();
			String sql = "select * from genre";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Genre g = new Genre(rs.getInt(1),rs.getString(2));
				list.add(g);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 장르코드별 도서정보 가져오기
	public ArrayList<Book> mainbooklist(int g_code){
		ArrayList<Book> list = new ArrayList<>();
		try {
			dbCon();
			String sql = "select * from book where g_code = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, g_code);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Book b = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
				list.add(b);
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	private void dbCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 도서코드로 해당도서 상세정보 불러오기
	public Book getbook(String b_code) {
		Book b = null;
		try {
			dbCon();
			String sql="select b_code, b_name, author, publisher, g_code, to_char(publication_date,'yyyy-mm-dd'), img, b_summary from book where b_code = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b_code);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				b = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	// 책 제목 검색하면 해당 도서 불러오기
	public Book searchbook(String b_name) {
		Book b = null;
		
		try {
			dbCon();
			String sql = "select NVL(max(b_code), 'no code')as b_code from book where b_name = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b_name);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				b = new Book(rs.getString(1));
			}
			rs.close();
			pst.close();
			con.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	// 리뷰 db에 넣기
	public void insertreview(Review r) {
		
		try {
			dbCon();
			String sql=" insert into review values(re_seq.nextval,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, r.n_id);
			pst.setString(2, r.b_code);
			pst.setString(3, r.content);
			pst.setString(4, r.r_date);
			pst.executeQuery();
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 저장된 리뷰들 도서코드로 불러오기
	public ArrayList<Review> getreviews(String b_code) {
		ArrayList<Review> list = new ArrayList<>();
		try {
			dbCon();
			String sql="select r_num, n_id, b_code, content, to_char(r_date, 'yy-mm-dd') from review where b_code = ? order by r_num asc";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b_code);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Review r = new Review(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(r);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 댓글(리뷰) 삭제 
	public void deletereview(int r_num) {
		try {
			dbCon();
			String sql="delete from review where r_num = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, r_num);
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void main(String[] args) {
		/*
		MainDao dao = new MainDao();
		dao.deletereview(3);
		
		ArrayList<Book> list = dao.getPageBooks(1,10);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPublication_date());
		}
		
		ArrayList<Genre> list3 = dao.genrelist();
		System.out.println(list3.size());
		for(int i=0; i<list3.size(); i++) {
			System.out.println(list3.get(i).getG_name());
		}
		ArrayList<Book> list2 = dao.mainbooklist("20");
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getB_name());
		}
		System.out.println(dao.getTotal(80));
		 
		ArrayList<Review> list = dao.getreviews("b1001");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getContent());
		}
		*/
	}

}
