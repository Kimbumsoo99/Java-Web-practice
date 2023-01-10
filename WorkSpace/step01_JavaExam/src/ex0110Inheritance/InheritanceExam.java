package ex0110Inheritance;
class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}
class EfSonata extends Car{
	EfSonata() {
		carname = "소나타";	
		this.cost = 30000;	//부모랑 이름이 안겹쳐서 상관없
	}
}
class Excel extends Car{
	Excel() {
		super.carname = "엑셀";		//부모랑 이름이 안겹쳐서 상관없
		cost = 23000;
	}
}
class Carnival extends Car{
	Carnival() {
		carname = "카니발";	
		cost = 18000;
	}
}
//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
	
	

public class InheritanceExam{
	public static void main(String[] args) {
		//메인메소드에서 
		Car car = new Car();
		EfSonata sonata = new EfSonata();
		Excel ex = new Excel();
		Carnival carnival = new Carnival();
			//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		System.out.println("-----------------------------");
		car.printAttributes();
		sonata.printAttributes();
		ex.printAttributes();
		carnival.printAttributes();
			// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
			
	}

	
}

