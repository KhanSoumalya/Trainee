package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Employee;
import com.nit.service.EmployeeService;
import java.util.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	
	@GetMapping("/showall")
	public List<Employee> showall()
	{
		return es.showAll();
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee emp){
		try {
			es.save(emp);
			return new ResponseEntity<>("User inserted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			
		return new ResponseEntity<>("Error in saving ",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Employee emp,@PathVariable int id)
	{
		try {
			Employee e=es.findById(id);
			es.save(emp);
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<String>("User doesnot exist",HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * @PostMapping("/new/{id}/{loc}") public ResponseEntity<String>
	 * update(@PathVariable String id, String loc) { try { es.upd(id, loc); return
	 * new ResponseEntity<String>("Success",HttpStatus.OK); }
	 * catch(NoSuchElementException e) { return new
	 * ResponseEntity<String>("IO Eroor",HttpStatus.OK); } }
	 */
	
	@DeleteMapping("/del/{name}")
	public ResponseEntity<?> delEmployee(@PathVariable Integer name)
	{
		try {
			es.del(name);
			return new ResponseEntity<String>("Employee Deleted",HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<String>("IO Eroor",HttpStatus.OK);
		}
	}
	

}
