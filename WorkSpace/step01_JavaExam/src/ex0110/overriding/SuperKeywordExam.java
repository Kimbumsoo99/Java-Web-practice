package ex0110.overriding;

class Super {
	int a = 10;
	int b = 5;

	public void aa() {
		System.out.println("Super의 aa() 호출..");
	}

	public void bb() {
		System.out.println("Super의 bb() 호출..");
	}
}

class Sub extends Super {
	int a = 20;
	int c = 100;

	@Override
	public void aa() {
		System.out.println("Sub의 aa() 호출");
	}

	public void cc() {
		System.out.println("Sub의 cc() 호출");
	}

	public void test() {
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(super.a);

		System.out.println("-----------------------------------");
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(super.b);

		System.out.println("-----------------------------------");
		System.out.println(c);
		System.out.println(this.c);
		System.out.println("-----------------------------------");
		// System.out.println(super.c);

	}

	public void test2() {
		aa();
		this.aa();
		super.aa();
		System.out.println("-----------------------------------");

		bb();
		this.bb();
		super.bb();
		System.out.println("-----------------------------------");

		cc();
		this.cc();
//		super.cc();
		System.out.println("-----------------------------------");
	}
}

public class SuperKeywordExam {

	public static void main(String[] args) {
//		new Sub().test();
//		new Sub().test2();

//		Sub s = new Sub();
//		System.out.println(s.a);
//		System.out.println(s.b);
//		System.out.println(s.c);
//
//		System.out.println("--메소드 호출--");
//		s.aa();
//		s.bb();
//		s.cc();
		
		Super s = new Sub();
		System.out.println(s.a);
		System.out.println(s.b);
//		System.out.println(s.c);

		System.out.println("--메소드 호출--");
		s.aa();
		s.bb();
//		s.cc();
		if(s instanceof Sub) {
			Sub s2 = (Sub)s;
			System.out.println(s2.c);
			s2.cc();
		}
		
		
	}

}