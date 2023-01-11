package sample01;



public class SampleAnswer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SampleFullTime[] full = new SampleFullTime[3];
		SamplePartTime[] part = new SamplePartTime[2];
		
		int len = full.length;
		for( SampleFullTime f : full ){
			  System.out.println(f);
			}
		
		full[0] = new SampleFullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		full[1] = new SampleFullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100);
		full[2] = new SampleFullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);

		part[0] = new SamplePartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
		part[1] = new SamplePartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);

		System.out.println("\n---------------------FullTime 정보-----------------------------------------");
		for( SampleFullTime f : full ){
			  System.out.println(f);
			}
		// 출력화면을 보고 코딩...
		len = part.length;
		System.out.println("\n---------------------PartTime 정보-----------------------------------------");
		for(int i=0;i<len;i++) {
			System.out.println(part[i]);
		}
		
		System.out.println("\n---------------------Message-----------------------------------------");
		len = full.length;
		for(int i=0;i<len;i++) {
			full[i].message();
		}
		len = part.length;
		for(int i=0;i<len;i++) {
			part[i].message();
		}
	}

}
