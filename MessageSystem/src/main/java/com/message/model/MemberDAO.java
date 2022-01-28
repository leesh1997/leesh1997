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
			// OracleDriver Ŭ������ �ش� ��ġ�� ���°��(ojdbc6.jar ������)
			// �ذ���: WEB-INF->lib->ojdbc6.jar ����

			// 2. OracleDriver ��ΰ� ��Ÿ�ΰ��
			e.printStackTrace();
		} catch (SQLException e) {
			// DB���� ������ ��Ȯ���� ���� ���

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
			// 1.SQL������ �߸� �ۼ��Ǿ��� ���
			// 2.psmt��ü�� �߸��� �ε������� �ۼ����� ���
			// 3.���̺��� ���� ���
			e.printStackTrace();
		} finally {
			// try~catch���� ����� �� �ݵ�� �����ϴ� ����
			close();
		}

		return cnt;

	}

	public MemberDTO memberLogin(String email, String pw) {

		connect();

		MemberDTO member = null;
		sql = "select m_tel, m_address from web_member where m_email=? and m_pw=?";
		// ����� ���̺� �̸��ϰ� ��й�ȣ�� �´� ��ȭ��ȣ�� �ּ� ��������
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) { // ȸ�����Ե� ������ DB�� �ִ°��
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
				// rs��ü �� ����� ȸ���������� ���� -> Member��ü ���� -> list�� ����
				String m_email = rs.getString(1);
				String m_tel = rs.getString(2);
				String m_address = rs.getString(3);
				
				if(!m_email.equals("admin")) { // ������ ������ �����ϰ� ����
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
