package ex0110Inheritance;

class CarCenter {
	//매개변수를 이용한 다형성
	public void engineer(Car cd) {
		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");

	}
}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();
		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();

		Car c = new Car();
		System.out.println("=============================================");
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
	}
}
