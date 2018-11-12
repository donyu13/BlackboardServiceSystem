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

import com.xinrong.system.student_information_system.datamodel.Announcement;
import com.xinrong.system.student_information_system.service.Services;

@Path("announcements")
public class AnnouncementResource {

	Services announcementService = Services.getServicesInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Announcement> getAllAnnouncements() {
		return announcementService.getAllItems(Announcement.class);
	}

	@GET
	@Path("{announcementID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement getAnnouncementById(@PathParam("announcementID") long announcementID) {
		return announcementService.getItemById(Announcement.class, announcementID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement createAnnouncement(Announcement announcement) {
		if (announcementService.getItemById(Announcement.class, announcement.getAnnouncementId()) != null)
				return null;
		return announcementService.addOrUpdateItem(announcement);
	}
	
	@DELETE
	@Path("{announcementID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement deleteAnnouncementById(@PathParam("announcementID") long announcementID) {
		return announcementService.deleteItemById(Announcement.class, announcementID);
	}
	
	@PUT
	@Path("{announcementID}")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Announcement updateAnnouncementInfo(@PathParam("announcementID") long announcementID, Announcement updatedAnnouncement) {
		if (announcementID != updatedAnnouncement.getAnnouncementId())
			return null;
		return announcementService.addOrUpdateItem(updatedAnnouncement);
	}

}








