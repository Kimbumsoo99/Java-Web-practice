package ex0111.exception;

class Test {
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa() 메소드 호출됨");
	//	try {
			this.bb(i);
		//} catch (ArithmeticException e) {
	//		System.out.println("0으로 나눌수 없어요!");
	//	}
		System.out.println("aa() 메소드 끝!!");		//얘를 출력하고싶다면 try랑 finally 사용
	}

	public void bb(int i) throws ArithmeticException {
		System.out.println("bb() 메소드 호출됨");
		try {
			int result = 100 / i;
			System.out.println("나눈 결과 : " + result);
		} finally {
			System.out.println("bb() 메소드 끝!!!");
		}
	}
}

public class ThrowExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--- 메인 시작하기 ---");
		try {
		Test t = new Test();
		t.aa(0);
		}catch(ArithmeticException e) {
			System.out.println("메인 오류 처리했어요");
		}
		System.out.println("--- 메인 종료하기 ---");

	}
}
