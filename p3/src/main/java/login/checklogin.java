package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ajaxtest4")
public class checklogin extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");

		String id = req.getParameter("n_id");	
		String pw = req.getParameter("n_pw");	
		HttpSession session = req.getSession();
		
		UserDao dao = new UserDao();		
		boolean result = dao.CheckLogin(id,pw);
		
		PrintWriter out = resp.getWriter();	
		
		//System.out.println(result);
		//System.out.println(id , pw);
		
		if(result) {
			// 세션가져오기			
			session.setAttribute("id", id);			
			out.println(1);
			
		}else {
			out.println(0);				
		}
		
		// 세션가져오기
		//HttpSession session = req.getSession();
		//session.setAttribute("id", id);
	}
}