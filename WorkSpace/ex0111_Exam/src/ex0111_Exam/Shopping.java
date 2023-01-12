package ex0111_Exam;

public class Shopping {

	public Shopping() {
	}

	public Shopping(int age) throws ExceptionProcessing  {
		if (age > 18) {
			System.out.println("입장하신걸 환영합니다.");
		} else {
			throw new ExceptionProcessing("애들은 가라");
		}

	}
}
