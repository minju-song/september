package co.project.prjdb.book.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.book.service.BookService;
import co.project.prjdb.book.service.BookVO;
import co.project.prjdb.book.serviceImpl.BookServiceImpl;


@WebServlet("/AjaxBookList.do")
public class AjaxBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxBookList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService dao = new BookServiceImpl();
		List<BookVO> list = dao.bookList();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
