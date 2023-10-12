package co.project.prjdb.notice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.prjdb.notice.service.NoticeVO;
import co.project.prjdb.notice.serviceImpl.NoticeServiceImpl;
import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.notice.service.*;

/**
 * Servlet implementation class SelectNotice
 */
@WebServlet("/noticeselect.do")
public class NoticeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeSelect() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		
		vo = dao.noticeSelect(vo);
		dao.noticeHitUpdate(vo.getNoticeId());
		request.setAttribute("n", vo);
		String page = "notice/noticeselect2";
		ViewResolve.forward(request, response, page);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
