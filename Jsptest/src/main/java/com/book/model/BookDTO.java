package com.book.model;

public class BookDTO {

	String id;
	String pw;
	String nick;
	String email;
	String tel;
	public BookDTO(String id, String pw, String nick, String email, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.email = email;
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", pw=" + pw + ", nick=" + nick + ", email=" + email + ", tel=" + tel + "]";
	}
	
	
	
}
