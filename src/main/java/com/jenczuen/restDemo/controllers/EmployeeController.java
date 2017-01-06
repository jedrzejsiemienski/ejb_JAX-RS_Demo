package com.jenczuen.restDemo.controllers;

import java.util.ArrayList;
import java.util.List;

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
	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		
		EmployeeDTO e1 = new EmployeeDTO();
		e1.setName("nazwa");
		result.add(e1);
		
		EmployeeDTO e2 = new EmployeeDTO();
		e2.setName("nazwa2");
		result.add(e2);
		
		return result;
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(EmployeeDTO e) {
		String result = "Got employee with name : " + e.getName();
		//return Response.status(201).entity(result).build();
		return Response.status(201).build();
	}

}
