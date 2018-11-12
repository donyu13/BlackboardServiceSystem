package com.xinrong.system.student_information_system.datamodel;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Courses")
public class Course extends DynamoDBObject{
	
	private String id;

	private long courseId;
	private long professorId;
	private long TAId;
	private String department;
	private long boardId;
	private List<Long> roster;

	public Course() {

	}


	public Course(long courseId, long professorId, long tAId, String department, long boardId, List<Long> roster) {
		super();
		this.courseId = courseId;
		this.professorId = professorId;
		TAId = tAId;
		this.department = department;
		this.boardId = boardId;
		this.roster = roster;
	}



	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBHashKey(attributeName = "CourseId")
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@DynamoDBAttribute(attributeName = "ProfessorId")
	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	@DynamoDBAttribute(attributeName = "TAId")
	public long getTAId() {
		return TAId;
	}

	public void setTAId(long TAId) {
		this.TAId = TAId;
	}

	@DynamoDBAttribute(attributeName = "Department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBAttribute(attributeName = "BoardId")
	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	@DynamoDBAttribute(attributeName = "Roster")
	public List<Long> getRoster() {
		return roster;
	}

	public void setRoster(List<Long> roster) {
		this.roster = roster;
	}

}
