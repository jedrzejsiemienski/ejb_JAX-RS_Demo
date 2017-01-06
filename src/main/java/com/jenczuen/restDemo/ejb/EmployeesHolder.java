package com.jenczuen.restDemo.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.jenczuen.restDemo.dtos.EmployeeDTO;

@Stateless
public class EmployeesHolder {

	List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

	public List<EmployeeDTO> getAll(){
		return list;
	}
	
	public Boolean save(EmployeeDTO e){
		if(e == null){
			return false;
		}
		list.add(e);
		return true;
	}
}
