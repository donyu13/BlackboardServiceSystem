package com.xinrong.system.student_information_system.datamodel;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBConnector {

	private static AmazonDynamoDB amazonDynamoDB;
	private static DynamoDBConnector dynamoDBConnector = null;
	private static DynamoDBMapper dynamoDBMapper;

	public DynamoDBConnector() {
		try {
			if (amazonDynamoDB == null) {
				InstanceProfileCredentialsProvider credentialsProvider = new InstanceProfileCredentialsProvider(false);
//				 ProfileCredentialsProvider credentialsProvider = new
//				 ProfileCredentialsProvider();
				credentialsProvider.getCredentials();
				amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
						.withRegion("us-east-2").build();
				System.out.println("I created the client");

			}
		} catch (Exception ex) {
			System.out.println("CONNECTION FAILED : " + ex.getMessage());
		}
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

	}

	public static DynamoDBConnector getDynamoDBConnector() {
		if (dynamoDBConnector == null)
			dynamoDBConnector = new DynamoDBConnector();
		return dynamoDBConnector;
	}

	public static DynamoDBMapper getDynamoDBMapper() {
		if (dynamoDBConnector == null)
			dynamoDBConnector = new DynamoDBConnector();
		return dynamoDBMapper;
	}

}
