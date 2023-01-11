package sample02;

public class SampleFullTime extends SampleEmployee {
	private int salary;
	private int bonus;
	
	
	public SampleFullTime() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SampleFullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName,int salary, int bonus) {
		super(empNo, eName, job, mgr, hiredate, deptName);	//부모의 생성자 사용
		this.salary = salary;
		this.bonus = bonus;
		// TODO Auto-generated constructor stub
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());

		builder.append("salary=");
		builder.append(salary);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println(getEname()+"사원은 정규직사원입니다.");
	}


}
