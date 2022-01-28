package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class S_MemberDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// DB������
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

	// DB����������
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

	// ȸ�����Ա��
	public int memberJoin(S_MemberDTO member) {
		
		connect();

		String sql = "insert into s_member values(?,?,?)";
		int cnt = 0;
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getM_id());
			psmt.setString(2, member.getM_pw());
			psmt.setString(3, member.getM_nick());

			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			//1.SQL������ �߸� �ۼ��Ǿ��� ���
			//2.psmt��ü�� �߸��� �ε������� �ۼ����� ���
			//3.���̺��� ���� ���
			e.printStackTrace();
		} finally {
			// try~catch���� ����� �� �ݵ�� �����ϴ� ����
			close();
		}
		
		return cnt;
		
	}
}
