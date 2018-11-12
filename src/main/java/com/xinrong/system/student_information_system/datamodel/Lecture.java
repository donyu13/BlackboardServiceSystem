package com.xinrong.system.student_information_system.datamodel;

import java.util.List;

public class Lecture {
	
	private String lectureID;
	private String lectureName;
	
	private Course course;
	private List<Note> noteList;
	private List<Material> materialList;


	public String getLectureID() {
		return lectureID;
	}

	public void setLectureID(String lectureID) {
		this.lectureID = lectureID;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}
	
	
}
