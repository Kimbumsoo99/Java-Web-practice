package sku.mvc.dto;

public class UserDTO {
   private String userId; //DB user_id
   private String pwd;
   private String name;
   private String age;
   private String phone;
   private String addr;
   
   public UserDTO() {}
   public UserDTO(String userId, String pwd) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		
	}
	public UserDTO(String userId, String pwd, String name) {
	this(userId, pwd);
	this.name = name;
    }
	
	public UserDTO(String userId, String pwd, String name, String age, String phone, String addr) {
		this(userId, pwd, name);
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
