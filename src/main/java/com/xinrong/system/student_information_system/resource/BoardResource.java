package com.xinrong.system.student_information_system.resource;

import com.xinrong.system.student_information_system.datamodel.Board;
import com.xinrong.system.student_information_system.datamodel.Course;
import com.xinrong.system.student_information_system.service.Services;

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

@Path("boards")
public class BoardResource {
	Services boardService = Services.getServicesInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Board> getAllBoards() {
		return boardService.getAllItems(Board.class);
	}
	
	@GET
	@Path("{boardID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Board getBoardById(@PathParam("boardID") long boardID) {
		return boardService.getItemById(Board.class, boardID);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Board createBoard(Board board) {
		if (boardService.getItemById(Course.class, board.getBoardId()) != null) {
			return null;
		}
		return boardService.addOrUpdateItem(board);
	}

	@DELETE
	@Path("{boardID}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Board deleteBoardByID(@PathParam("boardID") long boardID) {
		return boardService.deleteItemById(Board.class, boardID);
	}

	@PUT
	@Path("{boardID}")
	@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Board updateBoardInfo(@PathParam("boardID") long boardID, Board updatedBoard) {
		if (boardID != updatedBoard.getBoardId())
			return null;
		return boardService.addOrUpdateItem(updatedBoard);
	}
}
