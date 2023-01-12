package ex0111_Exam_sol;

public class ShoppingMall {
	public ShoppingMall() {
	}

	public void enter(int age) throws AgeCheckException {
		if (age < 18) {
			// throw 발생할객체변수;
			AgeCheckException ex = new AgeCheckException("애들은 가라!");
			throw ex;	//에러발생했으니 처리해야함 1. 직접처리 or 2. 던지기
		}
		System.out.println("입장하신 걸 환영합니다!!");
	}
}
