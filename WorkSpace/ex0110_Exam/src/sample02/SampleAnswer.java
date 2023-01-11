package sample02;

public class SampleAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleEmployee emp [] =new SampleEmployee[5];
		
		emp[0] = new SampleFullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		emp[1] = new SampleFullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100);
		emp[2] = new SampleFullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);
		emp[3] = new SamplePartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
		emp[4] = new SamplePartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);
		System.out.println("-----------정보-----------------");
		for(SampleEmployee e : emp) {
			System.out.println(e);
		}
		System.out.println("\n-----------메세지-----------------");
		for(SampleEmployee e : emp) {
			e.message();
		}	
	}
}
