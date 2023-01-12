package ex0111_Exam;

public class ExceptionProcessing extends Exception {
	static int count = 0;
	public ExceptionProcessing() {	}
	public ExceptionProcessing(String msg) {
		super(msg);
		System.out.println(getMessage());
		//count+=1;
	}
}
