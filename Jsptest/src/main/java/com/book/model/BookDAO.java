package com.book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class BookDAO {

	
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
			e.printStackTrace();
		} catch (SQLException e) {

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

	public int bookJoin(BookDTO book) {

		connect();

		sql = "insert into book_member values(?,?,?,?,?)";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getId());
			psmt.setString(2, book.getPw());
			psmt.setString(3, book.getNick());
			psmt.setString(4, book.getEmail());
			psmt.setString(5, book.getTel());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;

	}

	public BookDTO bookLogin(String id, String pw) {

		connect();

		BookDTO book = null;
		sql = "select nick from book_member where id=? and pw=?";
		// ����� ���̺� �̸��ϰ� ��й�ȣ�� �´� ��ȭ��ȣ�� �ּ� ��������
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) { // ȸ�����Ե� ������ DB�� �ִ°��
				String nick = rs.getString(1);
				book = new BookDTO(null, null , nick, null, null);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return book;
	}

	

	
}
