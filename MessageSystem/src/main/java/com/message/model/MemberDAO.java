package com.message.model;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// OracleDriver 클래스가 해당 위치에 없는경우(ojdbc6.jar 미포함)
			// 해결방안: WEB-INF->lib->ojdbc6.jar 저장

			// 2. OracleDriver 경로가 오타인경우
			e.printStackTrace();
		} catch (SQLException e) {
			// DB연결 정보가 정확하지 않을 경우

			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int memberJoin(MemberDTO member) {

		connect();

		sql = "insert into web_member values(?,?,?,?)";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getM_email());
			psmt.setString(2, member.getM_pw());
			psmt.setString(3, member.getM_tel());
			psmt.setString(4, member.getM_address());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			// 1.SQL문장이 잘못 작성되었을 경우
			// 2.psmt객체로 잘못된 인덱스값을 작성했을 경우
			// 3.테이블이 없는 경우
			e.printStackTrace();
		} finally {
			// try~catch문이 실행된 후 반드시 실행하는 구문
			close();
		}

		return cnt;

	}

	public MemberDTO memberLogin(String email, String pw) {

		connect();

		MemberDTO member = null;
		sql = "select m_tel, m_address from web_member where m_email=? and m_pw=?";
		// 웹멤버 테이블에 이메일과 비밀번호가 맞는 전화번호와 주소 가져오기
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) { // 회원가입된 정보가 DB에 있는경우
				String tel = rs.getString(1);
				String address = rs.getString(2);
				member = new MemberDTO(email, null, tel, address);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return member;
	}

	public int memberUpdate(MemberDTO memberDTO) {

		connect();

		sql = "update web_member set m_pw=?, m_tel=?, m_address=? where m_email=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberDTO.getM_pw());
			psmt.setString(2, memberDTO.getM_tel());
			psmt.setString(3, memberDTO.getM_address());
			psmt.setString(4, memberDTO.getM_email());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<MemberDTO> memberSelectAll() {

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		connect();

		sql = "select m_email, m_tel, m_address from web_member";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				// rs객체 내 저장된 회원정보들은 접근 -> Member객체 생성 -> list에 저장
				String m_email = rs.getString(1);
				String m_tel = rs.getString(2);
				String m_address = rs.getString(3);
				
				if(!m_email.equals("admin")) { // 관리자 계정은 제외하고 저장
				list.add(new MemberDTO(m_email, null, m_tel, m_address));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
}
