package com.xinrong.system.student_information_system.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xinrong.system.student_information_system.datamodel.Course;
import com.xinrong.system.student_information_system.queuing.TopicUtil;
import com.xinrong.system.student_information_system.service.Services;

@Path("courses")
public class CourseResource {

	Services courseService = Services.getServicesInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourse() {
		return courseService.getAllItems(Course.class);
	}

	@GET
	@Path("{courseID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseByID(@PathParam("courseID") long courseID) {
		return courseService.getItemById(Course.class, courseID);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course createCourse(Course course) {
		if (courseService.getItemById(Course.class, course.getCourseId()) != null) {
			return null;
		}
		// Create a topic for course.
		String topicArn = new TopicUtil().addTopic(course.getCourseId());
		course.setNotificationTopic(topicArn);
		
		return courseService.addOrUpdateItem(course);
	}

	@DELETE
	@Path("{courseID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourseByID(@PathParam("courseID") long courseID) {
		return courseService.deleteItemById(Course.class, courseID);
	}

	@PUT
	@Path("{courseID}")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Course updateCourseInfo(@PathParam("courseID") long courseID, Course updatedCourse) {
		if (courseID != updatedCourse.getCourseId())
			return null;
		return courseService.addOrUpdateItem(updatedCourse);
	}
}
