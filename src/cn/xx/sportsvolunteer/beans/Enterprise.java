package cn.xx.sportsvolunteer.beans;

public class Enterprise {
	private int id;
	private String username;
	private String password;
	private String password2;
	private String enterpriseName;
	private String address;
	private String phonenumber;
	private String business;
	
	public Enterprise(String username, String password, String password2, String enterpriseName,
			String address, String phonenumber, String business) {
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.enterpriseName = enterpriseName;
		this.address = address;
		this.phonenumber = phonenumber;
		this.business = business;
	}

	public Enterprise() {}
	
	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
