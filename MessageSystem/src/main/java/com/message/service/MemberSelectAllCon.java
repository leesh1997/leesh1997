package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("/MemberSelectAllCon")
public class MemberSelectAllCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();

		ArrayList<MemberDTO> members = dao.memberSelectAll();
		
		request.setAttribute("members", members);
		
		//members라는 객체정보를 select.jsp로 전달하기 위해서 forward방식을 활용
		//why? redirect방식은 텍스트데이터만 전달이 가능하기때문!
		
		//★★★ session을 사용하지 않고 request를 사용하는 이유는?
		// -> 회원들의 정보는 select.jsp에서만 출력할 것이기 때문에 request영역에 저장
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
		dispatcher.forward(request, response);
		
		
	
	}

}
