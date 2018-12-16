package com.xinrong.system.student_information_system.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xinrong.system.student_information_system.datamodel.Registrar;

@Path("registerOffering")
public class RegistrarService {
	Services registrarService = Services.getServicesInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Registrar createOffering(Registrar registrar) {
		if (registrarService.getItemById(Registrar.class, registrar.getRegistrationId()) != null)
			return null;
		System.out.println(registrar.getRegistrationId());
		return registrarService.addOrUpdateItem(registrar);
	}
}
