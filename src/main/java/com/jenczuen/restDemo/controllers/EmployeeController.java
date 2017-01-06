package com.jenczuen.restDemo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jenczuen.restDemo.ejb.EmployeesHolder;

import com.jenczuen.restDemo.dtos.EmployeeDTO;

@Path("/employee")
public class EmployeeController {

	EmployeesHolder employeesHolder;
	
	@PostConstruct
	private void init() {
		try{
			InitialContext context = new InitialContext();
			employeesHolder = (EmployeesHolder)context.lookup("java:global/ejb_JAX-RS_Demo/EmployeesHolder");			
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeDTO> getAll() {
		return employeesHolder.getAll();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(EmployeeDTO e) {
		if(employeesHolder.save(e)){
			return Response.status(201).build();			
		} else {
			return Response.status(500).build();
		}
	}

}
