package co.project.prjdb.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.book.service.BookService;
import co.project.prjdb.book.service.BookVO;
import co.project.prjdb.book.serviceImpl.BookServiceImpl;


@WebServlet("/AjaxBookInsert.do")
public class AjaxBookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxBookInsert() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		BookVO vo = new BookVO();
		BookService dao =new BookServiceImpl();
		Map<String, Object> resultMap = new HashMap<>();
		
		vo.setBookId(request.getParameter("id"));
		vo.setBookName(request.getParameter("name"));
		vo.setBookWriter(request.getParameter("writer"));
		vo.setBookCompany(request.getParameter("company"));
		vo.setBookPrice(Integer.parseInt(request.getParameter("price")));
		
		if(dao.bookInsert(vo) == 1) {
			resultMap.put("retCode", "Success");
			resultMap.put("data", vo);
		}
		else {
			resultMap.put("retCode", "Fail");
			
		}
		
		String json = objectMapper.writeValueAsString(resultMap);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
