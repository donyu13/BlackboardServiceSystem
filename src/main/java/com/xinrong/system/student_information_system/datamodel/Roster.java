package com.xinrong.system.student_information_system.datamodel;

import java.util.List;

public class Roster {

	
	private List<Student> studentList;
	private Course course;


	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
