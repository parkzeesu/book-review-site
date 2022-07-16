package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxtest3")
public class findipw extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");
		
		String id = req.getParameter("n_id");	
		String name = req.getParameter("n_name");	
		String tel = req.getParameter("n_tel");
		
		UserDao dao = new UserDao();		
		String pw=dao.findpw(id,name,tel);
		
		//System.out.println( pw);
		//System.out.println( "result =" + id +" "+ name +" " + tel);
		PrintWriter out = resp.getWriter();	
		
		if( pw == null) {
			out.println("없는 아이디입니다. 아이디를 확인해 주세요");	
		}else {
			out.println(id +"님의 비밀번호는 " + pw + " 입니다");	
		}
	}

}
