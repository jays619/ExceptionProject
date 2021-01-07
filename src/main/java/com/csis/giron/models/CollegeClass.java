package com.csis.giron.models;

public class CollegeClass {
	
	private String className;
	private String classNum;
	
	public CollegeClass() {}
	
	public CollegeClass(String className, String sectionNumber) {
		this.className = className;
		this.classNum = sectionNumber;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String sectionNumber) {
		this.classNum = sectionNumber;
	}
	
	@Override
	public String toString() {
		return String.format("Class Information\n"+"Class name: %s \n" + "Class number: %s \n", getClassName(), getClassNum());
	}

}