package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mainbooklist")
public class MainBookList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainDao dao = new MainDao();
		ArrayList<Book> list = dao.mainbooklist(10);
		req.setAttribute("list", list);
		
		ArrayList<Book> list2 = dao.mainbooklist(20);
		req.setAttribute("list2", list2);
		
		ArrayList<Book> list3 = dao.mainbooklist(30);
		req.setAttribute("list3", list3);
		
		ArrayList<Book> list4 = dao.mainbooklist(40);
		req.setAttribute("list4", list4);
		
		ArrayList<Book> list5 = dao.mainbooklist(50);
		req.setAttribute("list5", list5);
		
		ArrayList<Book> list6 = dao.mainbooklist(60);
		req.setAttribute("list6", list6);
		
		ArrayList<Book> list7 = dao.mainbooklist(70);
		req.setAttribute("list7", list7);
		
		ArrayList<Book> list8 = dao.mainbooklist(80);
		req.setAttribute("list8", list8);
		
		ArrayList<Genre> Glist = dao.genrelist();
		req.setAttribute("Glist", Glist);
		
		req.getRequestDispatcher("/jsp/main/main.jsp").forward(req, resp);

	}
	
}
