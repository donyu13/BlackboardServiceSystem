package com.xinrong.system.student_information_system.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Announcements")
public class Announcement extends DynamoDBObject {

	private String id;
	private long announcementId;
	private String announcementText; // Ensure text size is no more than 160 characters.
	private long courseId;
	private long boardId;

	public Announcement() {

	}

	public Announcement(long announcementId, String announcementText, long boardId, long courseId) {
		this.announcementId = announcementId;
		this.announcementText = announcementText;
		this.boardId = boardId;
		this.courseId = courseId;
	}

	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBHashKey(attributeName = "AnnouncementId")
	public long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}

	@DynamoDBAttribute(attributeName = "AnnouncementText")
	public String getAnnouncementText() {
		return announcementText;
	}

	public void setAnnouncementText(String announcementText) {
		this.announcementText = announcementText;
	}

	@DynamoDBIndexHashKey(attributeName = "CourseId", globalSecondaryIndexName = "CourseIdInAnnouncement")
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@DynamoDBIndexHashKey(attributeName = "BoardId", globalSecondaryIndexName = "BoardIdInAnnouncement")
	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

}
