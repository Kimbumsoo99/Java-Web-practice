drop table Electronics;

create table Electronics(
	model_num varchar2(15) primary key, --상품번호
	model_name varchar2(20) not null,--상품이름
	price int,--가격
	description varchar2(100), --설명
	password varchar2(20) not null,--비밀번호
	writeday date  not null, --작성일
	readnum int, --조회수
	 fname varchar2(50), --파일이름
     fsize int --파일용량
);


insert into Electronics values('NT900X4D-A68','삼성샌스',1300000,'Windows 8','1111',sysdate,0,null,0); --sysdate는 날짜
insert into Electronics values('SHV-E250S','Galaxy Note II',1000000,'Wi-Fi bluetooth 4.0','1111',sysdate,0,null,0);
insert into Electronics values('NT900X4D-A99S','삼성샌스',1700000,'Windows 8','1111',sysdate,0,null,0);

select * from Electronics

 commit
 --------------------------------------------------
 --댓글테이블 작성하기 ( 부모글 한개에 여러개의 댓글을 작성할수 있다)
create table replies(
  reply_num number primary key,
  reply_content varchar2(100) not null,
  reply_regdate date,
  parent_model_num varchar2(15) references electronics(model_num)
);

--댓글번호에서 사용할 시퀀스 생성
create sequence replies_num_seq;

--샘플레코드 추가
select * from electronics order by writeday desc;
--ex)  A45 글에 댓글 3개
insert into replies values(replies_num_seq.nextval , 'A45 첫번째 댓글', sysdate , 'A45');
insert into replies values(replies_num_seq.nextval , 'A45 두번째 댓글', sysdate , 'A45');
insert into replies values(replies_num_seq.nextval , 'A45 세번째 댓글', sysdate , 'A45');

--ex) A13 글에 댓글 2개 
insert into replies values(replies_num_seq.nextval , 'A13 첫번째 댓글', sysdate , 'A13');
insert into replies values(replies_num_seq.nextval , 'A13 두번째 댓글', sysdate , 'A13');

commit

select * from replies;

--ex) 부모글의 댓글 정보 조회
select * from replies where parent_model_num='A13'
 

