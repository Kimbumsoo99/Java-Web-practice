package ex0111_Exam;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			try {
				new Shopping(getAge());
			} catch (ExceptionProcessing e) {
				ExceptionProcessing.count += 1;
			}
		}
		System.out.println("\n----------------------김범수------------------------");
		System.out.println("예외처리 발생 횟수 : " + ExceptionProcessing.count);
	}

	public static int getAge() {
		int rand = (int) (Math.random() * 55) + 1;
		System.out.print(rand + "살\t");
		return rand;
	}
}