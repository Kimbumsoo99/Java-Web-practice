package ex0111_Exam_sol;
/**
 * 나이가 18보다 작을때 발생하는 예외 클래스
 * */
public class AgeCheckException extends Exception {
	static int count;
	public AgeCheckException() {
		AgeCheckException.count++;
	}
	public AgeCheckException(String msg) {
		super(msg);
		AgeCheckException.count++;
	}
}
