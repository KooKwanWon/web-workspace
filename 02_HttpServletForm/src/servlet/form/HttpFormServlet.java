package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 한글처리..양방향!
		 * 
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId"); // form의 name
		String userPwd = request.getParameter("userPwd");

		String[] menuList = request.getParameterValues("menu");
		String sex = request.getParameter("sex");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<style>" + "body{background-color: navy;" + "font-weight: bold; color: white;}" + "</style>");

		out.println("<h2>정보를 출력합니다...</h2>");
		out.println("<p> ID : " + userId + "</p>");
		out.println("<p> PASSWORD : " + userPwd + "</p>");
		// 당신의 성별은 --> form.html 라디오 사용!
		out.println("<p> 당신의 성별은 : " + sex + "</p>");

		if (menuList != null) {
			out.println("<p> 선택한 메뉴 : " + Arrays.toString(menuList) + "</p>");

			out.println("<p>");
			for (int i = 0; i < menuList.length; i++) {
				out.println((i + 1) + "번 : " + menuList[i] + "<br>");
			}
			out.println("</p>");
		}

		out.println("</body></html>");

		out.close();
	}

}
