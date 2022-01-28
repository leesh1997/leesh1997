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

	// DB연결기능
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

	// DB연결종료기능
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

	// 회원가입기능
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
			//1.SQL문장이 잘못 작성되었을 경우
			//2.psmt객체로 잘못된 인덱스값을 작성했을 경우
			//3.테이블이 없는 경우
			e.printStackTrace();
		} finally {
			// try~catch문이 실행된 후 반드시 실행하는 구문
			close();
		}
		
		return cnt;
		
	}
}
