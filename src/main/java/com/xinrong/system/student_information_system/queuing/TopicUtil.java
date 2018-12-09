package com.xinrong.system.student_information_system.queuing;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class TopicUtil {
	
	private static AmazonSNS SNS_CLIENT = AmazonSNSClientBuilder.standard()
			.withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_EAST_2).build();
	private static final String TOPIC_PREFIX = "NotifyCourse-";
	
	public String addTopic(long courseId) {
		CreateTopicRequest createTopicRequest = new CreateTopicRequest(TOPIC_PREFIX + courseId);
		CreateTopicResult createTopicResult = SNS_CLIENT.createTopic(createTopicRequest);
		return createTopicResult.getTopicArn();
	}

	public void subscribe(String topicArn, String email) {
		SNS_CLIENT.subscribe(new SubscribeRequest(topicArn, "email", email));
		System.out.println("a new subscribe for topic: {email: " + email + ", topicArn: " + topicArn);
	}
}
