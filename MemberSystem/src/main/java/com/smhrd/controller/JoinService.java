package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.S_MemberDAO;
import com.smhrd.model.S_MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 아이디, 패스워드, 닉네임을 변수에 저장
		// input의 name속성값을 반드시 확인할 것!
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		S_MemberDAO dao = new S_MemberDAO();

//		S_MemberDTO member = new S_MemberDTO(id,pw,nick);
//		dao.memberJoin(member);

		int cnt = dao.memberJoin(new S_MemberDTO(id, pw, nick));
		
		if (cnt > 0) {
			response.sendRedirect("joinTrue.jsp");
		} else {
			response.sendRedirect("joinFalse.jsp");
		}

	}

}
