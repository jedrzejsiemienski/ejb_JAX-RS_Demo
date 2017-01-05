package com.jenczuen.restDemo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jenczuen.restDemo.dtos.TestDTO;

@Path("/employee")
public class EmployeeController {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestDTO printMessage(@PathParam("param") String msg) {
		TestDTO result = new TestDTO();
		result.setText("Restful example : " + msg + " " + MediaType.APPLICATION_JSON);
		result.setNumber(11);
		return result;
	}
	
}
