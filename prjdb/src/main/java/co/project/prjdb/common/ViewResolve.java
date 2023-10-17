package co.project.prjdb.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolve {
	public static void forward(HttpServletRequest request ,HttpServletResponse response, String page) throws ServletException, IOException {//전역 메소드를 만들어서 씀 (static)
		String prefix = "WEB-INF/views/";
		String suffix = ".html";
		String viewPage = prefix + page + suffix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);//이 페이지로 가서 작업해라
		dispatcher.forward(request, response);
	}
}
