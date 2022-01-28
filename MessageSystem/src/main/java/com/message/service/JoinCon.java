package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

public class JoinCon implements iCommand {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberJoin(new MemberDTO(email, pw, tel, address));
		
		if(cnt > 0) { // 회원가입 성공했을 때 -> join_success.jsp로 이동(email정보전달)
			request.setAttribute("success_data", email);
			
			//forward방식으로 페이지 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입 실패..!');");
			out.print("location.href='main_jstl.jsp';");
			out.print("</script>");
			
		}
	}

}
