package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 이메일은 회원정보수정 Form에서 입력받는 값이 아니기 때문에
		// 세션에서 가져와야 한다!
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		String email = member.getM_email();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(new MemberDTO(email, pw, tel, address));
		
		if(cnt > 0) {
			
			session.setAttribute("member", new MemberDTO(email, pw, tel, address));
			response.sendRedirect("main_jstl.jsp");
			
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원정보 수정실패!');");
			out.print("location.href = 'main_jstl.jsp';");
			out.print("</script>");
		}
		
	}

}
