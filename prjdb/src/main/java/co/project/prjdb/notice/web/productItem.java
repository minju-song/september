package co.project.prjdb.notice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.project.prjdb.common.ViewResolve;
import co.project.prjdb.notice.service.ItemService;
import co.project.prjdb.notice.service.ItemVO;
import co.project.prjdb.notice.serviceImpl.ItemServiceImpl;


@WebServlet("/productItem.do")
public class productItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public productItem() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemService dao = new ItemServiceImpl();
		ItemVO vo = new ItemVO();
//		vo.setItemId(request.getParameter("itemId"));
		
		vo = dao.itemSelect(request.getParameter("itemId"));
		request.setAttribute("n", vo);
		String page = "../../boot-shop/item";
		ViewResolve.forward(request, response, page);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
