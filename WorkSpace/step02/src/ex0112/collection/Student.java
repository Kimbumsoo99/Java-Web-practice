package ex0112.collection;

public class Student {
	private int sno;	//학번
	private String name;
	private String addr;
	
	public Student() {
	}
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	public Student(int sno, String name, String addr) {
		this(sno,name);
		this.addr = addr;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(sno);
		builder.append(" | ");
		builder.append(name);
		builder.append(" | ");
		builder.append(addr);

		return builder.toString();
	}
	
}
