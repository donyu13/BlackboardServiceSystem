package com.xinrong.system.student_information_system.datamodel;

public class Note {
	
	private String noteID;
	private String noteName;
	private String noteContent;
	
	private Lecture lecture;

	public String getNoteID() {
		return noteID;
	}

	public void setNoteID(String noteID) {
		this.noteID = noteID;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	
}
