package ex0110.sperConstructor;

class Parent{
	Parent(){
		System.out.println(1);
	}
	Parent(int i){
		System.out.println(2);
	}
	Parent(boolean b){
		System.out.println(3);
	}
}
class Child extends Parent{
	Child(){
		System.out.println(4);
	}
	Child(int i){
		this();
		System.out.println(5);
	}
	Child(int i, String s){
		this(i);
		System.out.println(6);
	}
}
public class SuperConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Child();
	}

}
