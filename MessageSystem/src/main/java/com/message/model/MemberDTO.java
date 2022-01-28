package com.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data: getter/setter 메소드를 자동으로 생성
//@NoArgsConstructor: 기본 생성자 생성
//@AllArgsConstructor: 모든 필드변수를 초기화하는 생성자 생성
@Data
@NoArgsConstructor
@AllArgsConstructor
//변수, 생성자, getter/setter, toString() 정의
public class MemberDTO {

	private String m_email;
	private String m_pw;
	private String m_tel;
	private String m_address;


}
