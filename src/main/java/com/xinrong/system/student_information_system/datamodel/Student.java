package com.xinrong.system.student_information_system.datamodel;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Students")
public class Student extends DynamoDBObject{
	
	private String id;
	
	private long studentId;
	private String firstName;
	private String lastName;
	private String joiningDate;
	private String department;
	private List<Long> registeredCourses;

	public Student() {

	}

	public Student(long studentId, String firstName, String lastName, String joiningDate, String department,
			List<Long> registeredCourses) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningDate = joiningDate;
		this.department = department;
		this.registeredCourses = registeredCourses;
	}

	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBHashKey(attributeName = "StudentId")
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@DynamoDBAttribute(attributeName = "StudentFirstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "StudentLastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@DynamoDBAttribute(attributeName = "StudentJoiningDate")
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@DynamoDBAttribute(attributeName = "Department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBAttribute(attributeName = "RegisteredCourses")
	public List<Long> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(List<Long> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

}