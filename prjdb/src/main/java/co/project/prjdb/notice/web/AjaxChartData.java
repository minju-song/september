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


@WebServlet("/AjaxChartData.do")
public class AjaxChartData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxChartData() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Integer> map = new HashMap<>();
		map.put("Work", 11);
		map.put("Eat", 2);
		map.put("Commute", 2);
		map.put("Watch TV", 2);
		map.put("Sleep", 7);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
