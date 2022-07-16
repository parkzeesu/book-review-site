package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchbook")
public class SearchBook extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainDao dao = new MainDao();
		
		String b_name = req.getParameter("b_name");
		
		//Book book2 = new Book("none");
		Book book2 = dao.searchbook(b_name);
		String b_code = book2.getB_code();
		
		// menu(장르) 불러오기
		ArrayList<Genre> Glist = dao.genrelist();
		req.setAttribute("Glist", Glist);
		
		//System.out.println(b_code);
		
		if(! book2.getB_code().equals("no code")) {
			
			// 도서 상세정보 불러오기
			Book book = dao.getbook(book2.getB_code());
			req.setAttribute("book", book);
			// System.out.print(book.getImg());
								
			// 리뷰 정보 불러오기
			ArrayList<Review> Rlist = dao.getreviews(book2.getB_code());
			if(Rlist != null) {
				req.setAttribute("Rlist", Rlist);
			}
			
			req.getRequestDispatcher("/jsp/bookSelect/bookSelect.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/jsp/bookSelect/bookSelect2.jsp").forward(req, resp);
			//resp.sendRedirect("/jsp/bookSelect/bookSelect2.jsp");
		}

	}

}
