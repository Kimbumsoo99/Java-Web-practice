package method;
class Methodinvoke01{
	//다음과 같이 메소드를 작성하세요.
	public int method01(int num1, int num2) {
		System.out.println("두 수의 곱은 "+ (num1*num2));
		return num1*num2;
	}
	/*method 이름 : method01
	어디서나 누구나 접근가능
	정수 리턴
	인수로 정수2개 받음
	인수로 들어온 정수 2개를 곱해서 출력하고 리턴*/
		
	
}

class Methodinvoke02{
	public int method02(int num1, int num2) {
		System.out.println("두 수의 합은 "+ (num1+num2));
		return num1+num2;
	}
	//method 이름 : method02
	//어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
	//정수 리턴
	//인수로 정수2개 받음
	
	//인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴
	
}

class MethodInvokeExam{
	public static void main(String []args){
		Methodinvoke01 m1 = new Methodinvoke01();
		m1.method01(3,5);
		//MethodInvoke01의 method01 호출
		Methodinvoke02 m2 = new Methodinvoke02();
		m2.method02(5, 8);

		//MethodInvoke02의 method02 호출
		

		

	}
}

