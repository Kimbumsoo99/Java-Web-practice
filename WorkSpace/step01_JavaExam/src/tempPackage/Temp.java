package tempPackage;

class A{
	private int a=30;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A asc = new A();
		System.out.println(asc.getA());
	}

}
