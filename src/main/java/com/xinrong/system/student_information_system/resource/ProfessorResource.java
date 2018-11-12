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

import com.xinrong.system.student_information_system.datamodel.Professor;
import com.xinrong.system.student_information_system.service.Services;

@Path("professors")
public class ProfessorResource {

	Services professorService = Services.getServicesInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getAllProfessors() {
		return professorService.getAllItems(Professor.class);
	}

	@GET
	@Path("{professorID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessorByID(@PathParam("professorID") long professorID) {
		return professorService.getItemById(Professor.class, professorID);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Professor createProfessor(Professor prof) {
		if (professorService.getItemById(Professor.class, prof.getProfessorId()) != null)
			return null;
		return professorService.addOrUpdateItem(prof);
	}

	@DELETE
	@Path("{professorID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Professor deleteProfessorByID(@PathParam("professorID") long professorID) {
		return professorService.deleteItemById(Professor.class, professorID);
	}

	@PUT
	@Path("{professorID}")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Professor updateProfessorInfo(@PathParam("professorID") long professorID, Professor updatedProfessor) {
		System.out.println("update here");
		if (professorID != updatedProfessor.getProfessorId())
			return null;
		return professorService.addOrUpdateItem(updatedProfessor);
	}
}
