package com.guhao.reflect.dest;

import java.util.List;

public class TargetUserClass {
	
	protected String sex;
    public String test;
	private String username;
	private String password;
	private Integer age;
	private List<String> likes;
	private Double score;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "TargetUserClass [sex=" + sex + ", test=" + test + ", username=" + username + ", password=" + password
				+ ", age=" + age + ", likes=" + likes + ", score=" + score + "]";
	}
	

}
