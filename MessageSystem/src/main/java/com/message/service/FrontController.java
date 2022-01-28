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
	// ArrayList ���� �ξ� �� ������
	
	@Override
	public void init() throws ServletException {
		// ������ ������ �� Ư�������� �ʱ�ȭ���ִ� �޼ҵ�
		map = new HashMap<String, iCommand>();
		map.put("/LoginCon.do", new LoginCon());
		map.put("/JoinCon.do", new JoinCon());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("���� ��û : " + command);
		
		// "/LoginCon.do" ��û�� ������ ��
		//iCommand com = map.get("/LoginCon.do");
		//iCommand com = new LoginCon();
		iCommand com = map.get(command);
		com.execute(request, response);
		
//		if(command.equals("/LoginCon.do")) {
//			//�α��� ó��
//			iCommand login = new LoginCon();
//			login.execute(request, response);
//			
//		} else if (command.equals("/JoinCon.do")) {
//			//ȸ������ ó��
//				JoinCon join = new JoinCon();
//				join.execute(request, response);
//			}
		}
		
		
	}


