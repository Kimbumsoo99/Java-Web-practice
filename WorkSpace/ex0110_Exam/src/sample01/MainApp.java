package sample01;

class FullTime{
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int salary;
	private int bonus;
	
	public FullTime(){};
	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		setEmpNo(empNo);
		seteName(eName);
		setJob(job);
		setMgr(mgr);
		setHiredate(hiredate);
		setDeptName(deptName);
		setSalary(salary);
		setBonus(bonus);
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
	
	public void message() {
		System.out.println(geteName()+"사원은 정규직입니다.");
	}
	
	public String toString() {
		int empNo = getEmpNo();
		String eName = geteName();
		String job= getJob();
		int mgr =  getMgr();
		String hiredate = getHiredate();
		String deptName = getDeptName();
		int salary = getSalary();
		int bonus = getBonus();
		return empNo+" | "+eName+" | "+job+" | "+mgr+" | "+hiredate+" | "+deptName+" | "+salary+" | "+bonus;
	}
}

class PartTime{
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
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
		System.out.println(geteName()+"사원은 비정규직입니다.");
	}
	
	public String toString() {
		int empNo = getEmpNo();
		String eName = geteName();
		String job= getJob();
		int mgr =  getMgr();
		String hiredate = getHiredate();
		String deptName = getDeptName();
		int timePay = getTimePay();
		return empNo+" | "+eName+" | "+job+" | "+mgr+" | "+hiredate+" | "+deptName+" | "+timePay;
	}
}


public class MainApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FullTime [] full = new FullTime[3];
		PartTime [] part = new PartTime[2];
		int len;
		
		full[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		full[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		full[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		
		part[0] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		part[1] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);

		System.out.println("***************** 김범수 *****************\n");
		System.out.println("***************** FullTime 정보 *****************");
		len = full.length;
		for(int i=0;i<len;i++){	
			System.out.println(full[i]);	
		}
		
		
		System.out.println("\n***************** PartTime 정보 *****************");
		len = part.length;
		for(int i=0;i<len;i++){	
			System.out.println(part[i]);	
		}
		System.out.println("\n***************** Message *****************");
		full[0].message();
		full[1].message();
		full[2].message();
		part[0].message();
		part[1].message();
		
	}

}






