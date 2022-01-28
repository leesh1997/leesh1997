package com.message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data: getter/setter �޼ҵ带 �ڵ����� ����
//@NoArgsConstructor: �⺻ ������ ����
//@AllArgsConstructor: ��� �ʵ庯���� �ʱ�ȭ�ϴ� ������ ����
@Data
@NoArgsConstructor
@AllArgsConstructor
//����, ������, getter/setter, toString() ����
public class MemberDTO {

	private String m_email;
	private String m_pw;
	private String m_tel;
	private String m_address;


}
