


create table users(
   user_id varchar2(10) primary key,	--DB에서는 user_id 같이 _가 관례임
   pwd varchar2(10), 
   name varchar2(10)
);

select * from users;



insert into users values('jang', '1234', '장희정');
insert into users values('lee', '1234', '이가현');

select user_id, pwd, name from users where user id=? and pwd=?
commit