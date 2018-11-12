package com.xinrong.system.student_information_system.service;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.xinrong.system.student_information_system.datamodel.DynamoDBConnector;
import com.xinrong.system.student_information_system.datamodel.DynamoDBObject;

/*
 * Generic Service class.
 */
public class Services {

	private static DynamoDBMapper dynamoDBMapper;
	private static Services services = null;

	public Services() {
		dynamoDBMapper = DynamoDBConnector.getDynamoDBMapper();
	}

	public static Services getServicesInstance() {
		if (services == null)
			services = new Services();
		return services;
	}

	// Search.
	public <T extends DynamoDBObject> T getItemById(Class<T> itemClass, long itemId) {
		return dynamoDBMapper.load(itemClass, itemId);
	}

	// Search all.
	public <T extends DynamoDBObject> List<T> getAllItems(Class<T> objectClass) {
		return dynamoDBMapper.scan(objectClass, new DynamoDBScanExpression());
	}

	// Delete.
	public <T extends DynamoDBObject> T deleteItemById(Class<T> itemClass, long itemId) {
		T item = dynamoDBMapper.load(itemClass, itemId);
		dynamoDBMapper.delete(item, new DynamoDBDeleteExpression());
		return item;
	}

	// Create and update.
	public <T extends DynamoDBObject> T addOrUpdateItem(T object) {
		dynamoDBMapper.save(object);
		return object;
	}

}
