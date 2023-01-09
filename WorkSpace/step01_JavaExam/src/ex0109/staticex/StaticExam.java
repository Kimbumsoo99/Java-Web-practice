package ex0109.staticex;

class Test {
	int a = 5;
	static int b = 10; // 공유 변수

	// non-static메소드에서 static, non-static모두 가능
	public void aa() {
		System.out.println(a);
		System.out.println(this.a);

		System.out.println(b);
		System.out.println(this.b);
		System.out.println(Test.b); // 권장
	}

	public void bb() {
		aa();
		this.aa(); // this. 은 생략이 가능해서 위랑 같은것

		cc();
		this.cc();
		Test.cc(); // 권장
	}

	// static 메소드 안에서 static만 접근, this 사용불가
	public static void cc() {
		// System.out.println(a);
		// System.out.println(this.a);

		System.out.println(b);
		// System.out.println(this.b);
		System.out.println(Test.b);
	}

	public static void dd() {
		// aa();
		// this.aa();

		cc();
		// this.cc();
		Test.cc();
	}

}

public class StaticExam {

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();

		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);

		// non-static 접근
		System.out.println("t1.a= " + t1.a);
		System.out.println("t2.a= " + t2.a);
		System.out.println("t3.a= " + t3.a);

		// non-static 변수의 값 변경
		t2.a = 100;

		// 변경후 출력
		System.out.println("t1.a= " + t1.a);
		System.out.println("t2.a= " + t2.a);
		System.out.println("t3.a= " + t3.a);

		// static 접근
		System.out.println("t1.b= " + t1.b);
		System.out.println("t2.b= " + t2.b);
		System.out.println("t3.b= " + t3.b);
		System.out.println("Test.b = " + Test.b);

		// static 변수의 값 변경
		t2.b = 100;

		// 변경후 출력
		System.out.println("t1.b= " + t1.b);
		System.out.println("t2.b= " + t2.b);
		System.out.println("t3.b= " + t3.b);
		System.out.println("Test.b = " + Test.b);

	}

}
