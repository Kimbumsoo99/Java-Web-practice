package ex0111.interfaceEx.exam;

import java.util.List;

public class FreeServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("FreeServiceImpl의 insert(Board board) 입니다..." + board);
		return 0;
	}

	@Override
	public List<Board> selectAll() {
		System.out.println("FreeServiceImpl의 selectAll() 입니다...");
		return null;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("FreeServiceImpl의 selectByNo(int no) 입니다..." + no);
		return null;
	}

	@Override
	public int update(Board board) {
		System.out.println("FreeServiceImpl의 update(Board board) 입니다..." + board);
		return 0;
	}

	@Override
	public int delete(int no) {
		System.out.println("FreeServiceImpl의 delete(int no) 입니다..." + no);
		return 0;
	}



}
