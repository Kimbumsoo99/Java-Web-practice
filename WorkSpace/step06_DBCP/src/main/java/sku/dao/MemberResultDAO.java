package sku.dao;

import java.util.List;

import sku.dto.MemberDTO;

public interface MemberResultDAO {
	/**
	 * 회원테이블 전체검색
	 * select * from member order by join_date desc
	 * */
	List<MemberDTO> selectAll();

	/**
	 * 회원가입
	 * insert into member(id,pwd,name,age,phone,addr, join_date)
		values(?,?,?,?,?,?, sysdate)	sysdate는 년월일시분초가 자동적으로 순간에 시간이 들어간다.
	 * */
	int insert(MemberDTO member);

	/**
	 * 아이디에 해당하는 회원 삭제
	 * DELETE FROM MEMBER WHERE ID=?
	 * */
	int delete(String id);
	
	
	/**
	 * 아이디에 해당하는 회원 상세보기
	 * select * from member where id=?
	 * (만약 없는 아이디를 검색해도 테이블 구조는 온다)
	 * 또한 이녀석은 Primary Key로 조건을 주기때문에 반드시 한문장만 온다 그래서 MemberDTO가 반환값
	 * */
	MemberDTO selectById(String id);
	
	/**
	 * 주소 or 아이디 or 이름에 포함된 문자열 포함된 레코드 검색
	 * select * from member where id like '%a%'
		select * from member where name like '%나%'
		select * from member where id addr '%서울%'
		얘네는 ?가 들어올 수 없다함.
	 * */
	List<MemberDTO> selectByFieldAndWord(String keyFiled, String keyWord);
		
}
