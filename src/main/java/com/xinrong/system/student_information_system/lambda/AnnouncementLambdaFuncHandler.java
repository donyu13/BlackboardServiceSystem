package com.xinrong.system.student_information_system.lambda;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

public class AnnouncementLambdaFuncHandler implements RequestHandler<DynamodbEvent, String> {
	private static AmazonSNS SNS_CLIENT = AmazonSNSClientBuilder.standard().withRegion("us-east-2").build();
	private static DynamoDB ddb = new DynamoDB(AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build());

	@Override
	public String handleRequest(DynamodbEvent event, Context context) {
		for (DynamodbStreamRecord record : event.getRecords()) {
			Map<String, AttributeValue> announcementImage = record.getDynamodb().getNewImage();
			if (record.getEventName().equals("INSERT")) {
				sendEmailNotification(getCourseTopicArn(announcementImage), constructAnnouncement(announcementImage));
			}
		}
		return "Sent notification";
	}

	private String constructAnnouncement(Map<String, AttributeValue> announcementImage) {
		return "Course " + announcementImage.get("CourseId").getN() + ": "
				+ announcementImage.get("AnnouncementText").getS();
	}

	private String getCourseTopicArn(Map<String, AttributeValue> announcementImage) {
		Table courseTable = ddb.getTable("Courses");
		Item courseItem = courseTable.getItem("CourseId", Integer.parseInt(announcementImage.get("CourseId").getN()));
		return courseItem.get("NotificationTopic").toString();
	}

	private void sendEmailNotification(String arn, String message) {
		PublishRequest publishRequest = new PublishRequest(arn, message);
		SNS_CLIENT.publish(publishRequest);
	}

}