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
import co.project.prjdb.notice.service.ItemService;
import co.project.prjdb.notice.service.ItemVO;
import co.project.prjdb.notice.serviceImpl.ItemServiceImpl;


@WebServlet("/productList.do")
public class productList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public productList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemService dao = new ItemServiceImpl();
		List<ItemVO> items = new ArrayList<>();
		
		items = dao.itemList();
		request.setAttribute("items", items);
		
		String page = "../../boot-shop/index";
		ViewResolve.forward(request, response, page);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
