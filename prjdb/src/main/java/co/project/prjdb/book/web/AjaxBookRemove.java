package co.project.prjdb.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.project.prjdb.book.service.BookService;
import co.project.prjdb.book.serviceImpl.BookServiceImpl;


@WebServlet("/AjaxBookRemove.do")
public class AjaxBookRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxBookRemove() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("id");
		BookService dao = new BookServiceImpl();
		
		if(dao.bookRemove(bid) == 1) {
			response.getWriter().print("{\"retCode\": \"Success\"}");
		}
		else {
			response.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
