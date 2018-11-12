package com.xinrong.system.student_information_system.datamodel;

public abstract class DynamoDBObject {
	public String id;

	public abstract String getId();

	public abstract void setId(String id);
}
