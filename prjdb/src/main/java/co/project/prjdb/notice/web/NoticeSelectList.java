package co.project.prjdb.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.notice.service.NoticeService;
import co.project.prjdb.notice.service.NoticeVO;
import co.project.prjdb.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticeselectlist.do")
public class NoticeSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSelectList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String page = "notice/noticeselectlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
