package sample02;

public abstract class SampleEmployee {
	private int empNo;
	private String ename;	//eName에서 수정하였음 표기법에 맞춰서 한것
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	
	public SampleEmployee() {}

	public SampleEmployee(int empNo, String ename, String job, int mgr, String hiredate, String deptName) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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
	public abstract void message();	//abstract는 only 선언

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SampleEmployee [empNo=");
		builder.append(empNo);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", job=");
		builder.append(job);
		builder.append(", mgr=");
		builder.append(mgr);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append(", deptName=");
		builder.append(deptName);
		builder.append(",");
		return builder.toString();
	}
	
	
}
