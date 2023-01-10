package ex0110constructor;

//싱글톤 클래스 만들기

class Test{
	private static Test instance = new Test();
	private Test() {
		
	}
	
	public static Test getInstance() {	//이런 getInstance는 static을 붙여야한다. 그래야 객체 생성없이 접근할 수 있다.
		//Test t = new Test();
		return instance;
	}
}
public class PrivateConstructorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Test(); 이렇게 하는것이 아니다. private 생성자를 가지고 있어서 불가능, Test가 필요할 때 메소드 호출 이용
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		
		
	}

}
