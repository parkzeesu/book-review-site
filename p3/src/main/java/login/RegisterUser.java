package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");
		
		String n_id=req.getParameter("n_id");
		String n_pw=req.getParameter("n_pw");
		String n_name=req.getParameter("n_name");
		String n_tel=req.getParameter("n_tel");
		
		
		User u = new User(n_id,n_pw,n_name,n_tel);
		UserDao dao = new UserDao();
		dao.RegisterUser(u);
		
		resp.sendRedirect("jsp/Register/confirm.jsp");
	}
	}