package com.message.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	private int m_num;
	private String m_sendName;
	private String m_receiveEmail;
	private String m_content;
	private String m_sendDate;

	
}
