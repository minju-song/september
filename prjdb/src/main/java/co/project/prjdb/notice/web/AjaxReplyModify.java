package co.project.prjdb.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.notice.service.ReplyService;
import co.project.prjdb.notice.service.ReplyVO;
import co.project.prjdb.notice.serviceImpl.ReplyServiceImpl;


@WebServlet("/AjaxReplyModify.do")
public class AjaxReplyModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxReplyModify() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String rid = request.getParameter("rid");
		String reply = request.getParameter("content");
		
		ReplyVO vo = new ReplyVO();
		vo.setReplyId(Integer.parseInt(rid));
		vo.setReply(reply);
		
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(svc.editReply(vo)) {
			vo = svc.getReply(Integer.parseInt(rid));
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
