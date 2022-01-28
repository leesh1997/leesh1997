package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDTO;
import com.message.model.MessageDAO;

@WebServlet("/MsgDeleteCon")
public class MsgDeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		//�޽��� ��ȣ�� ������ ����
		String num = request.getParameter("num");
		String email = member.getM_email();
		
		MessageDAO dao = new MessageDAO();
		
		int cnt = dao.messageDelete(email, num);
		
		if(cnt > 0) {
			response.sendRedirect("main_jstl.jsp");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('�޽��� ���� ���п���~');");
			out.print("location.href = 'main_jstl.jsp';");
			out.print("</script>");
		}
		
		
	}

}
