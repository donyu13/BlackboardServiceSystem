package com.xinrong.system.student_information_system.datamodel;

public class CourseEvent {
	private long courseId;
	private String department;
	private long boardId;

	public CourseEvent() {

	}

	public CourseEvent(long courseId, String department) {
		this.courseId = courseId;
		this.department = department;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "{\"courseId\": \"" + courseId + "\", \"department\": \"" + department + "\", \"boardId\": \"" + boardId
				+ "\"}";
	}

}
