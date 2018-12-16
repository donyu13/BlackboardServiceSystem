package com.xinrong.system.student_information_system.lambda;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.xinrong.system.student_information_system.datamodel.Course;
import com.xinrong.system.student_information_system.queuing.TopicUtil;


public class CourseLambdaFuncHandler implements RequestHandler<Course, Course> {
	private static AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	private static DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(ddb);
	
	@Override
	public Course handleRequest(Course event, Context context) {
		// A course is new if boardId, listofRegisteredStudents and its notificationTopic field are empty. 
		if (event.getNotificationTopic() == null) {
			String topicArn = new TopicUtil().addTopic(event.getCourseId());
			event.setNotificationTopic(topicArn);
		}
		if (event.getRoster() == null) {
			event.setRoster(new ArrayList<Long>());
		}
		if (event.getBoardId() == 0) {
			dynamoDBMapper.save(event);
		}
		return event;
	}
}