package org.afroz.practice.ejb;

import java.io.Serializable;

public class Student implements Serializable {

	private String sName;
	private Long id;
	private int age;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		super();
	}

	public Student(String sName, int age) {
		super();
		this.sName = sName;
		this.id = (long) (StudentBean.students.size()+1);
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [sName=" + sName + ", id=" + id + ", age=" + age + "]";
	}
	
	
}
