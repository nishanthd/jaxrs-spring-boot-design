package com.maroon.fridge.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maroon.fridge.exception.NoItemFoundException;
import com.maroon.fridge.service.FridgeService;

/**
 * 
 * @author Nishanth Dharmaraju
 *
 */
@Component
@Path("/fridge")
public class FridgeController {

	@Autowired
	FridgeService fridgeService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItems() {

		return Response.ok(fridgeService.getAllItems()).build();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItemById(@PathParam("id") Integer itemId) throws NoItemFoundException {

		return Response.ok(fridgeService.getItemByType(itemId)).build();
	}

}
