package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ascgetpagebooks")
public class GetPageBooksAsc extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MainDao dao = new MainDao();
		
		// 장르번호, 페이지 불러오기	
		int code = Integer.parseInt(req.getParameter("code"));
		int page = Integer.parseInt(req.getParameter("page"));
		int st = Integer.parseInt(req.getParameter("st"));
		System.out.print(st);
		
		// menu(장르) 불러오기
		ArrayList<Genre> Glist = dao.genrelist();
		req.setAttribute("Glist", Glist);
			
		// 장르별 책리스트
		ArrayList<Book> list = dao.ascgetPageBooks(page, code);
		req.setAttribute("list", list);
		
		// menu(장르)별 소제목
		Genre genre = dao.genrename(code);
		req.setAttribute("genre", genre);
				
		// 장르별 요소 개수
		int totalCnt = dao.getTotal(code);
		req.setAttribute("totalCnt",totalCnt);
				
		// 페이지
		req.setAttribute("code", code);
		req.setAttribute("page", page);
		req.setAttribute("st", st);
		
		req.getRequestDispatcher("/jsp/main/AscGetPageBooks.jsp").forward(req, resp);
	}

}
