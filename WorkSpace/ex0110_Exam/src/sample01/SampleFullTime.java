package sample01;


/**
 * 정규직사원의 정보 관리(DTO = VO)
 */
public class SampleFullTime {
	private int empNo;
	private String eName; // 사실 잘못된 표기법이다. 단어와 단어를 조합할때 낙타표기법 쓰는거라 e는 알파벳이라 의미가 없다.
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int salary;
	private int bonus;

	// private 붙인것은 정보 은닉
	public SampleFullTime() {
	} // 기본 생성자를 만들어야하는것은 누군가의 부모가 됐을 때 기본생성자가 없으면 누군가의 부모가 되기 어렵다.

	public SampleFullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		super(); // 자식의 생성자 첫번째줄에는 생략되어있어서 쓴것 안써도됨.
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() { // 이 부분 때문에 잘못된 이름이었던것 eName이
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

	public void message() { // 이 기능은 초기단계가 아닌 요구사항이나 절차에 맞춰서 내용을 채우면 된다.
		System.out.println(eName+"사원은 정규직사원입니다.");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SampleFullTime [empNo=");
		builder.append(empNo);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", deptName=");
		builder.append(deptName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");
		return builder.toString();
	}



}
