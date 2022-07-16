package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxtest2")
public class findid extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");
		
		String name = req.getParameter("n_name");	
		String tel = req.getParameter("n_tel");
		
		UserDao dao = new UserDao();		
		String id=dao.findid(name,tel);
		
		//System.out.println( id);
		//System.out.println( "result =" + name +" " + tel);
		PrintWriter out = resp.getWriter();	
		
		if( id == null) {
			out.println("아이디가 존재하지 않습니다");	
		}else {
			out.println(name +"님의 아이디는 " + id + " 입니다");	
		}
	}

}
