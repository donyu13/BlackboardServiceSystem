package com.xinrong.system.student_information_system.resource;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xinrong.system.student_information_system.datamodel.Student;
import com.xinrong.system.student_information_system.lambda.AnnouncementLambdaFuncHandler;
import com.xinrong.system.student_information_system.queuing.TopicUtil;
import com.xinrong.system.student_information_system.datamodel.Course;
import com.xinrong.system.student_information_system.service.Services;

@Path("students")
public class StudentResource {

	Services studentService = Services.getServicesInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return studentService.getAllItems(Student.class);
	}

	@GET
	@Path("{studentID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByID(@PathParam("studentID") long studentID) {
		return studentService.getItemById(Student.class, studentID);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(Student student) {
		if (studentService.getItemById(Student.class, student.getStudentId()) != null)
			return null;
		return studentService.addOrUpdateItem(student);
	}

	@POST
	@Path("{studentID}/register")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN })
	@Produces(MediaType.APPLICATION_JSON)
	public Student register(@PathParam("studentID") long studentID, long courseID) {
		Student student = studentService.getItemById(Student.class, studentID);
		Course course = studentService.getItemById(Course.class, courseID);

		if (student == null || course == null)
			return null;

		if (student.getRegisteredCourses() == null)
			student.setRegisteredCourses(new ArrayList<Long>());
		
		// A student can register for a max of 3 courses.
		if (student.getRegisteredCourses().size() < 3) {
			student.getRegisteredCourses().add(courseID);
			if (course.getRoster() == null)
				course.setRoster(new ArrayList<Long>());
			course.getRoster().add(studentID);

			studentService.addOrUpdateItem(student);
			studentService.addOrUpdateItem(course);
			new TopicUtil().subscribe(course.getNotificationTopic(), student.getEmailId());
		}
		return student;
	}

	@DELETE
	@Path("{studentID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudentByID(@PathParam("studentID") long studentID) {
		return studentService.deleteItemById(Student.class, studentID);
	}

	@PUT
	@Path("{studentID}")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudentInfo(@PathParam("studentID") long studentID, Student updatedStudent) {
		if (studentID != updatedStudent.getStudentId())
			return null;
		return studentService.addOrUpdateItem(updatedStudent);
	}
}
