package sample02;

public class SamplePartTime extends SampleEmployee {
	private int timePay;
	
	
	
	
	public SamplePartTime() {
		super();
		// TODO Auto-generated constructor stub
	}




	public SamplePartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName,int timePay) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.timePay = timePay;
		// TODO Auto-generated constructor stub
	}




	public int getTimePay() {
		return timePay;
	}




	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("timePay=");	
		builder.append(timePay);
		builder.append("]");
		return builder.toString();
	}




	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println(getEname()+"사원은 비정규직사원입니다.");
	}
}
