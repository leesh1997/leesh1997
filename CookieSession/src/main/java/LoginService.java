

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String s_id = "����";
		String s_pw = "1234";
		String s_nick = "����";
		
		response.setContentType("text/html; charset=UTF-8");
			if(s_id.equals(id) && s_pw.equals(pw)){
				
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("nick", s_nick);
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect("loginF.jsp");
			} 
			
		
		/*
		 * out.print("<html><head></head><body>"); out.print(id);
		 * out.print("</body></html>");
		 */
		
		
	}

}
