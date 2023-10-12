package co.project.prjdb.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.member.service.MemberService;
import co.project.prjdb.member.service.MemberVO;
import co.project.prjdb.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlist.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		list = dao.memberSelectList();
		request.setAttribute("members", list); //보여준 페이지에 돌아온 결과를 보여줄때 members에 list를 담겠다는 뜻
		
		String page = "member/memberlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
