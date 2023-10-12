package co.project.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.notice.service.ItemService;
import co.project.prjdb.notice.service.ItemVO;
import co.project.prjdb.notice.serviceImpl.ItemServiceImpl;

/**
 * Servlet implementation class AjaxProductFour
 */
@WebServlet("/AjaxProductFour.do")
public class AjaxProductFour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxProductFour() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemService dao = new ItemServiceImpl();
		List<ItemVO> items = dao.itemListFour();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(items);
		
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
