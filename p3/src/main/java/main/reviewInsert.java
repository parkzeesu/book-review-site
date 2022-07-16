package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reviewInsert")
public class reviewInsert extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainDao dao = new MainDao();
		
		//HttpSession session = req.getSession();

		// int num = Integer.parseInt(req.getParameter("num"));
		String id = req.getParameter("id");
		String bcode = req.getParameter("bcode");
		String content = req.getParameter("content");
		String date = req.getParameter("date");
		
		Review r = new Review(id, bcode, content, date);
		dao.insertreview(r);
		
		// menu(장르) 불러오기
		ArrayList<Genre> Glist = dao.genrelist();
		req.setAttribute("Glist", Glist);
		
		// 도서 상세정보 불러오기
		Book book = dao.getbook(bcode);
		req.setAttribute("book", book);
		// System.out.print(book.getImg());
		
		// 리뷰 정보 불러오기
		ArrayList<Review> Rlist = dao.getreviews(bcode);
		if(Rlist != null) {
			req.setAttribute("Rlist", Rlist);
		}
		
		req.getRequestDispatcher("/jsp/bookSelect/bookSelect.jsp").forward(req, resp);
	}
}
