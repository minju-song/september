package co.project.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.notice.service.ReplyService;
import co.project.prjdb.notice.service.ReplyVO;
import co.project.prjdb.notice.serviceImpl.ReplyServiceImpl;


@WebServlet("/AjaxReplySearch.do")
public class AjaxReplySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxReplySearch() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO vo = svc.getReply(Integer.parseInt(rid));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(vo);
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().append(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
