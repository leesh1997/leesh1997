create table s_member(
	m_id varchar(30),
	m_pw varchar(30),
	m_nick varchar(30),
	constraint pk_s_member primary key(m_id)
);


insert into s_member values('smhrd','1234','Ω∫¿Œ∞≥');

select * from s_member

drop table s_member