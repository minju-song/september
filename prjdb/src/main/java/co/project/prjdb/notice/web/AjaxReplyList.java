package co.project.prjdb.notice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.project.prjdb.notice.service.*;
import co.project.prjdb.notice.serviceImpl.*;
@WebServlet("/AjaxReplyList.do")
public class AjaxReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxReplyList() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		
		//추가 
		String param = request.getParameter("param");

		ReplyService dao = new ReplyServiceImpl();
		List<ReplyVO> list = dao.listReply(Integer.parseInt(nid));
		
		if (param == null) {			
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(list);
			
			response.setContentType("text/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		} else {
			//{"data" : [[], [], ... , []]}
			String json = "{\"data\":[";
			int cnt = 0;
//			for(ReplyVO vo : list) {
//				json += "[" 
//			+"\""+vo.getReplyId()+"\","
//			+"\""+vo.getReplyer()+"\","
//			+"\""+vo.getReply()+"\","
//			+"\""+vo.getReplyDate()+"\""
//						+ "]";
//				if(++cnt != list.size()) {
//					json+=",";
//				}
//			}
			
			json += "]}";
			Map<String, Object> map = new HashMap<>();
			map.put("data", list);
			
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(map);
			
			response.setContentType("text/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
