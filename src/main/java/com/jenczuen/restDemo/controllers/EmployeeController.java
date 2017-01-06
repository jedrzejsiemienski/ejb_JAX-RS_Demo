package com.jenczuen.restDemo.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jenczuen.restDemo.dtos.EmployeeDTO;

@Path("/employee")
public class EmployeeController {

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDTO getAll() {
		EmployeeDTO e = new EmployeeDTO();
		e.setName("nazwa");
		return e;
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(EmployeeDTO e) {
		String result = "Got employee with name : " + e.getName();
		return Response.status(201).entity(result).build();
	}
	
}
