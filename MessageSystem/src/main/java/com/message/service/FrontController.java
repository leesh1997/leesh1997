package com.message.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.message.model.MemberDAO;
import com.message.model.MemberDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, iCommand> map;
	// ArrayList 보다 훨씬 더 빠르다
	
	@Override
	public void init() throws ServletException {
		// 서버가 실행할 때 특정값들을 초기화해주는 메소드
		map = new HashMap<String, iCommand>();
		map.put("/LoginCon.do", new LoginCon());
		map.put("/JoinCon.do", new JoinCon());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("들어온 요청 : " + command);
		
		// "/LoginCon.do" 요청이 들어왔을 때
		//iCommand com = map.get("/LoginCon.do");
		//iCommand com = new LoginCon();
		iCommand com = map.get(command);
		com.execute(request, response);
		
//		if(command.equals("/LoginCon.do")) {
//			//로그인 처리
//			iCommand login = new LoginCon();
//			login.execute(request, response);
//			
//		} else if (command.equals("/JoinCon.do")) {
//			//회원가입 처리
//				JoinCon join = new JoinCon();
//				join.execute(request, response);
//			}
		}
		
		
	}


