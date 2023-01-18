package sku.dto;

public class MemberDTO {
	private String id;
	private int pwd;
	private String name;
	private int age;
	private String phone;
	private String addr;
	private String joinDate;
	
	public MemberDTO() {}
	
	/**
	 * id, pwd, name, age, phone, addr, joinDate
	 * */
	public MemberDTO(String id, int pwd, String name, int age, String phone, String addr, String joinDate) {
		this(id, name, age, addr);
		this.pwd = pwd;
		this.phone = phone;
		this.joinDate = joinDate;
	}

	public MemberDTO(String id, String name, int age, String addr) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
}
