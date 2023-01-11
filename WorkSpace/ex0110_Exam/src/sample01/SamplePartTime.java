package sample01;


public class SamplePartTime {
	private int empNo;
	private String eName; // 사실 잘못된 표기법이다. 단어와 단어를 조합할때 낙타표기법 쓰는거라 e는 알파벳이라 의미가 없다.
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int timePay;

	public SamplePartTime() {
	}

	public SamplePartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.timePay = timePay;
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

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}

	public void message() {
		System.out.println(eName+"사원은 비정규직사원입니다.");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SamplePartTime [empNo=");
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
		builder.append(", timePay=");
		builder.append(timePay);
		builder.append("]");
		return builder.toString();
	}
}