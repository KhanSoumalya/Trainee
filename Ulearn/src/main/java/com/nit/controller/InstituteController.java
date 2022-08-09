package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Institute;
import com.nit.service.InstituteService;
import java.util.*;

@RestController
public class InstituteController {
	
	@Autowired
	InstituteService ins;
	
	@PostMapping("/update")
	public Institute updateIns(@PathVariable String name, String location)
	{
		return ins.upadateName(name, location);
	}
	
	@GetMapping("/all")
	public List<Institute> allIns()
	{
	return ins.viewAll();	
	}
	

}
