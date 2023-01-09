package method;
//MakeMethodExam.java
class MakeMethodExam {
	public static void main(String[] args) {
		MakeMethodExam mme = new MakeMethodExam();
		int k = mme.methodExam01(33);
		System.out.println(k);
		mme.methodExam02();
		mme.methodExam03(42);
		String s = mme.methodExam04(17);
		System.out.println(s);

	}

	private int methodExam01(int num) {
		return num * 2;
	}
	/*
	 * Method이름 : methodExam01 자기자신만 접근가능 Return Type : 정수 Parameter : 정수1개
	 * (구현부에서)하는일 : 인수로 받은(들어온)정수를 출력하고 인수에 2를 곱해 Return
	 */

	public void methodExam02() {
		System.out.println("연습!");
	}
	/*
	 * Method이름 : methodExam02 어디에서나 아무나 접근가능 Return 안함 Parameter 없음 (구현부에서)하는일 :
	 * 아무거나 출력
	 */

	void methodExam03(int num) {
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
	}
	/*
	 * Method이름 : methodExam03 같은pakage내에서 아무나 접근가능 Return Type : Return 안함
	 * Parameter : 정수1개 (구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고 그수가 짝수라면 "짝수",홀수라면"홀수" 출력
	 */

	
	protected String methodExam04(int num) {
		System.out.println("들어온 정수는 "+num);
		if(num%2==0) {
			return "짝수";
		}
		else {
			return "홀수";
		}
	}
	/*
	 * Method이름 : methodExam04 상속관계라면 어디서나 접근가능 
	 * Return Type : String타입 
	 * Parameter :
	 * 정수1개 
	 * (구현부에서)하는일 : 인수로 받은(들어온) 정수를 출력하고 
	 * 그수가 짝수라면 "짝수",홀수라면"홀수" 리턴
	 */

}
