package com.campus.myapp.vo;

public class MemberVO {
	private String userid;
	private String userpwd;
	private String username;
	
	private String birthdate;
	private String birthdate1;
	private String birthdate2;
	private String birthdate3;
	
	private String gender;
	private String mbti;
	private String registerdate;
		
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthdate() {
		 
		if(Integer.parseInt(birthdate3) < 10) {
			birthdate = birthdate1 + "-" + birthdate2 + "-0" + birthdate3;
		} else {
			birthdate = birthdate1 + "-" + birthdate2 + "-" + birthdate3;
		}
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		String birthdateSp[] = birthdate.split("-");
		birthdate1 = birthdateSp[0];
		birthdate2 = birthdateSp[1];
		birthdate3 = birthdateSp[2];
		this.birthdate = birthdate;
	}
	public String getBirthdate1() {
		return birthdate1;
	}
	public void setBirthdate1(String birthdate1) {
		this.birthdate1 = birthdate1;
	}
	public String getBirthdate2() {
		return birthdate2;
	}
	public void setBirthdate2(String birthdate2) {
		this.birthdate2 = birthdate2;
	}
	public String getBirthdate3() {
		return birthdate3;
	}
	public void setBirthdate3(String birthdate3) {
		this.birthdate3 = birthdate3;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	
	
}
