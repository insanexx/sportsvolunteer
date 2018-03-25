package cn.xx.sportsvolunteer.beans;

import java.util.Date;

public class Volunteer {
	private String id;
	private int age;
	private String username;
	private String password;
	private String password2;
	private String gender;
	private String address;
	private String idcardnumber;
	private String phonenumber;
	private String specialskill;
	private Date registertime;
	
	public Volunteer() {}
	
	public Volunteer(String id, int age, String username, String password, String password2, String gender,
			String address, String idcardnumber, String phonenumber, String specialskill, Date registertime) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.gender = gender;
		this.address = address;
		this.idcardnumber = idcardnumber;
		this.phonenumber = phonenumber;
		this.specialskill = specialskill;
		this.registertime = registertime;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdcardnumber() {
		return idcardnumber;
	}
	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSpecialskill() {
		return specialskill;
	}
	public void setSpecialskill(String specialskill) {
		this.specialskill = specialskill;
	}
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", age=" + age + ", username=" + username + ", password=" + password
				+ ", gender=" + gender + ", address=" + address + ", idcardnumber=" + idcardnumber + ", phonenumber="
				+ phonenumber + ", specialskill=" + specialskill + ", registertime=" + registertime + "]";
	}
}
