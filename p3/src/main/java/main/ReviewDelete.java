package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reviewdelete")
public class ReviewDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainDao dao = new MainDao();
		
		String bcode = req.getParameter("bcode");
		int r_num = Integer.parseInt(req.getParameter("r_num"));
		
		//System.out.print(r_num);
		
		// 댓글 삭제
		dao.deletereview(r_num);
				
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
