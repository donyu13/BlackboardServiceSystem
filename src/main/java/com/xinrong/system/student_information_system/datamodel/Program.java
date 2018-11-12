package com.xinrong.system.student_information_system.datamodel;

import java.util.List;

public class Program {
	
	private String programID;
	private String programName;
	
	private List<Course> courseList;
	private List<Student> studentList;


	public String getProgramID() {
		return programID;
	}


	public void setProgramID(String programID) {
		this.programID = programID;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public List<Course> getCourseList() {
		return courseList;
	}


	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}


	public List<Student> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
