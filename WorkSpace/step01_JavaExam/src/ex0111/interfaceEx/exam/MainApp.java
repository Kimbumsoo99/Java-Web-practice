package ex0111.interfaceEx.exam;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---- 각 게시판 TEST 해보자 ----");
		
		BoardService service=null;
		Board board = null;
		
		System.out.println("---- 1. FreeBoard TEST ----");
		service = new FreeServiceImpl();	//필드를 이용한 다형성
		board = new FreeBoard(10,"범수","Java실습","재밌는줄 알았어");
		test(service, board);		
		
		System.out.println("---- 2. QABoard TEST ----");
		service = new QAServiceImpl();	//필드를 이용한 다형성
		board = new QABoard(20,"지윤","곰돌이","호랑이");
		test(service, board);
		
		System.out.println("---- 3. UploadBoard TEST ----");
		service = new UploadServiceImpl();	//필드를 이용한 다형성
		board = new UploadBoard(30,"범수","토끼띠","가나다라","api.jpg");
		test(service, board);
	}
	
	public static void test(BoardService service, Board board) {//매개변수를 이용한 다형성
		//각 게시판의 CRUD를 호출해보자
		//~.insert, delete, update
		service.insert(board);
		service.selectAll();
		service.selectByNo(board.getNo());
		service.update(board);
		service.delete(board.getNo());
		System.out.println("\n------------------------------");
	}

}
