package sample02;

abstract class Employee {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;

	public Employee() {

	}

	public Employee(int empNo, String eName, String job, int mgr, String hiredate, String deptName) {

	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String toString() {

		return null;
	}

	abstract void message();
}

class FullTime extends Employee {
	private int salary;
	private int bonus;

	public FullTime() {
	}

	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		setEmpNo(empNo);
		seteName(eName);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setDeptName(deptName);
		setSalary(salary);
		setBonus(bonus);
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

	public String toString() {
		int empNo = getEmpNo();
		String eName = geteName();
		String job = getJob();
		int mgr = getMgr();
		String hiredate = getHiredate();
		String deptName = getDeptName();
		int salary = getSalary();
		int bonus = getBonus();
		return empNo + " | " + eName + " | " + job + " | " + mgr + " | " + hiredate + " | " + deptName + " | " + salary
				+ " | " + bonus;
	}

	void message() {
		System.out.println(geteName() + "사원은 정규직입니다.");
	}

}

class PartTime extends Employee {
	private int timePay;

	public PartTime() {

	}

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		setEmpNo(empNo);
		seteName(eName);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setDeptName(deptName);
		setTimePay(timePay);
	}

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}

	public String toString() {
		int empNo = getEmpNo();
		String eName = geteName();
		String job = getJob();
		int mgr = getMgr();
		String hiredate = getHiredate();
		String deptName = getDeptName();
		int timePay = getTimePay();
		return empNo + " | " + eName + " | " + job + " | " + mgr + " | " + hiredate + " | " + deptName + " | "
				+ timePay;
	}

	void message() {
		System.out.println(geteName() + "사원은 비정규직입니다.");
	}
}

public class MainApp {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Employee[] emp = new Employee[5];
		emp[0] = new FullTime();
		emp[1] = new FullTime();
		emp[2] = new FullTime();
		emp[3] = new PartTime();
		emp[4] = new PartTime();

		int len = emp.length;

		emp[0] = new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		emp[1] = new FullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100);
		emp[2] = new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);
		emp[3] = new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
		emp[4] = new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);
		System.out.println("***************** 김범수 *****************\n");
		System.out.println("***************** Emp 정보 *****************");
		for (int i = 0; i < len; i++) {
			System.out.println(emp[i]);
		}
		System.out.println("\n***************** Emp Message *****************");

		for (int i = 0; i < len; i++) {
			emp[i].message();
		}

	}

}