package com.xinrong.system.student_information_system.lambda;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xinrong.system.student_information_system.datamodel.Course;
import com.xinrong.system.student_information_system.datamodel.Registrar;

public class RegisterLambdaFuncHandler implements RequestHandler<Course, Course> {
	private static HttpClient HTTP_CLIENT = HttpClientBuilder.create().build();
	private static Gson GSON = new GsonBuilder().create();

//	private static AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-2").build();
//	private static DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(ddb);

	@Override
	public Course handleRequest(Course course, Context context) {
//		To get access to dynamoDB directly:
//		Registrar registrar = new Registrar();
//		registrar.setRegistrationId(course.getCourseId());
//		registrar.setOfferingId(course.getCourseId());
//		registrar.setOfferingType("Course");
//		registrar.setDepartment(course.getDepartment());
//		registrar.setPerUnitPrice(1000);
//		dynamoDBMapper.save(registrar);

		HttpPost httppost = new HttpPost(
				"http://blackboardservice-env.agrb8ruvva.us-east-2.elasticbeanstalk.com/webapi/registerOffering");
		try {
			Registrar registrar = new Registrar();
			registrar.setRegistrationId(course.getCourseId());
			registrar.setOfferingId(course.getCourseId());
			registrar.setOfferingType("Course");
			registrar.setDepartment(course.getDepartment());
			registrar.setPerUnitPrice(1000);

			httppost.setEntity(new StringEntity(GSON.toJson(registrar)));
			httppost.setHeader("Content-type", "application/json");

			HttpResponse response = HTTP_CLIENT.execute(httppost);
			System.out.println(EntityUtils.toString(response.getEntity()));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course;
	}

}
