create table book_member(
	id varchar(50),
	pw varchar(50) not null,
	nick varchar(50),
	email varchar(50),
	tel varchar(50),
	constraint book_member_pk primary key(id)
)

select * from book_member