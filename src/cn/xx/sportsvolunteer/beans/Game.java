package cn.xx.sportsvolunteer.beans;

import java.util.Date;

public class Game {
	private String id;
	private String name;
	private String description;
	private String jobdescription;
	private Date begintime;
	private Date endtime;
	private String address;
	private double salary;
	private int enterpriseid;
	private String enterprisename;
	private boolean entered;
	public boolean isEntered() {
		return entered;
	}
	public void setEntered(boolean entered) {
		this.entered = entered;
	}
	public String getEnterprisename() {
		return enterprisename;
	}
	public void setEnterprisename(String enterprisename) {
		this.enterprisename = enterprisename;
	}
	public int getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(int enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	private int personcount;
	private int restcount;
	
	public int getRestcount() {
		return restcount;
	}
	public void setRestcount(int restcount) {
		this.restcount = restcount;
	}
	public int getPersoncount() {
		return personcount;
	}
	public void setPersoncount(int personcount) {
		this.personcount = personcount;
	}
	public Game() {}
	public Game(String id, String name, String description, String jobdescription, Date begintime, Date endtime,
			String address, double salary,int enterpriseid,int personcount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobdescription = jobdescription;
		this.begintime = begintime;
		this.endtime = endtime;
		this.address = address;
		this.salary = salary;
		this.enterpriseid = enterpriseid;
		this.personcount = personcount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", jobdescription="
				+ jobdescription + ", begintime=" + begintime + ", endtime=" + endtime + ", address=" + address
				+ ", salary=" + salary + "]";
	}
	
}
