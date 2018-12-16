package com.xinrong.system.student_information_system.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.xinrong.system.student_information_system.datamodel.Board;
import com.xinrong.system.student_information_system.datamodel.Course;

public class BoardLambdaFuncHandler implements RequestHandler<Course, Course> {
	private static AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
	private static DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(ddb);

	@Override
	public Course handleRequest(Course course, Context context) {
		Board board = new Board();
		// Define boardId the same as courseId.
		long courseId = course.getCourseId();
		board.setBoardId(courseId);
		board.setCourseId(courseId);
		course.setBoardId(courseId);
		dynamoDBMapper.save(board);
		dynamoDBMapper.save(course);
		return course;
	}

}
