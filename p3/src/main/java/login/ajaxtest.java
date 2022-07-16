package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajaxtest")
public class ajaxtest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String id = req.getParameter("n_id");		
		//System.out.println( req.getParameter("n_id"));
		UserDao dao = new UserDao();		
		boolean result=dao.duplicatedID(id);
		
		//System.out.println( "result =" + result);
		PrintWriter out = resp.getWriter();	
		
		if( result) {
			out.println(1);	
		}else {
			out.println(0);	
		}
		
		
		 
	}
}