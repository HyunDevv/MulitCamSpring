package com.vo;

public class MemberVO {
	private String id;
	private String pwd;
	private int age;
	private String gender;
	private String it;

	public String getIt() {
		return it;
	}

	public void setIt(String it) {
		this.it = it;
	}

	public MemberVO(String id, int age, String gender, String it) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.it = it;
	}

	public MemberVO() {
		super();
	}

	public MemberVO(String id, String pwd, int age, String gender) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
	}

	public MemberVO(String id, int age, String gender) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", age=" + age + ", gender=" + gender + ", it=" + it + "]";
	}
	

}