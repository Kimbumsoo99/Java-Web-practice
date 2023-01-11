package ex0111.interfaceEx.exam;
/**
 * 각 게시판들의 공통의 기능을 규격서(메소드의 선언문)를 제공하는 interface
 * 	 : CRUD 작업
 * */

import java.util.List;

public interface BoardService {
	/**
	 * 등록(QA, upload, free)
	 * @return 0이면 실패, 1이상이면 성공
	 * */
	int insert(Board board);
	
	/**
	 * 전체검색
	 * */
	List<Board> selectAll();
	
	/**
	 * 글번호 검색
	 * */
	Board selectByNo(int no);
	
	/**
	 * 수정
	 * @return 0이면 실패, 1이상이면 성공
	 * */
	int update(Board board);
	
	/**
	 * 삭제
	 *  : 글번호에 해당하는 게시물 삭제
	 * @return 0이면 실패, 1이상이면 성공
	 * */
	int delete(int no);
	
	/** 
	 * Freeboard에서만 사용하는 메소드 추가
	 * 이런경우 오버라이드하라고 문제가 발생한다 모든 객체에
	 * 그래서 {}중괄호와 default를 추가하면 달 수 있다.
	 * */
	default List<Board> selectByWriter(String writer){
		//기능
		return null;
	}
}
