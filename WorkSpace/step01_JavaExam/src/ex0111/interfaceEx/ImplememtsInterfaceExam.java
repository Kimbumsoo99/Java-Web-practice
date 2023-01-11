package ex0111.interfaceEx;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00 {
	abstract void interfaceExam00();
}

interface InterfaceExam01 extends InterfaceExam00 {
	final int i = 767;
	int k = 999;

	void interfaceExam01(int i, int k);
}

interface InterfaceExam02 {
	int j = 747;
	int privateInt = 8;

	void interfaceExam02(int j);
}

class SuperClassExam {
	String superString = "Super";

	String superMethod() {
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01 {

	@Override
	public void interfaceExam00() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interfaceExam01(int i, int k) {
		// TODO Auto-generated method stub

	}

}

class SubClassExam02 extends SuperClassExam implements InterfaceExam01, InterfaceExam02 {

	@Override
	public void interfaceExam00() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interfaceExam01(int i, int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void interfaceExam02(int j) {
		// TODO Auto-generated method stub

	}

}

abstract class SubClassExam03 extends SuperClassExam implements InterfaceExam01, InterfaceExam02 {
}

class SubClassExam04 extends SubClassExam02 {
	// 여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00() {

	}

	public void interfaceExam01(int i, int k) {

	}

	public void interfaceExam02(int j) {

	}

	SubClassExam04() {
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = " + i);
		System.out.println(" j = " + j);
	}

	SubClassExam04(String s1, String s2) {
		System.out.println(s1 + " 타입 " + "subClassExam04(" + s2 + ") 객체 생성");

	}

	void printSuperString() {
		// InterfaceExam01 ie01 = new InterfaceExam01();

		System.out.println(" superString = " + superString);
	}
}

//여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam {
	public static void main(String args[]) {
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1, 7);
		sub04.superMethod();
	}
}
