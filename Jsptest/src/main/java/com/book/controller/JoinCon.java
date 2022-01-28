package com.book.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.model.BookDAO;
import com.book.model.BookDTO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
	
		BookDAO dao = new BookDAO();
		int cnt = dao.bookJoin(new BookDTO(id,pw,nick,email,tel));
		
		if(cnt > 0) {
			request.setAttribute("success", nick);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Question4_Login.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('회원가입 실패..!');");
			out.print("location.href='Question4_Join.jsp';");
			out.print("</script>");
		}
		
	}
}
