package co.project.prjdb.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.project.prjdb.common.Sha256;
import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.member.service.MemberService;
import co.project.prjdb.member.service.MemberVO;
import co.project.prjdb.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();//세션객체를 호출한다. true->세션이 없으면 만들어주라는 뜻
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(Sha256.encrypt(request.getParameter("memberPassword")));

		vo = dao.memberSelect(vo);
		if(vo != null) {
			//여기서 session 객체에 필요한 데이터를 담아준다.
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("name", vo.getMemberName());
			
			request.setAttribute("message", vo.getMemberName()+"님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		
		String page = "member/membermessage";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
