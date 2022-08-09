package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

import com.nit.entity.Institute;
import com.nit.repo.InstituteRepo;

@Service
public class InstituteService {
	
	@Autowired
private InstituteRepo repo;
	
	//add method
	public Institute add(Institute ins)
	{
		return repo.save(ins);
	}
	
	public Institute upadateName(String name,String location)
	{
		return repo.findByName(name, location);
		
	}
	
	public List<Institute> viewAll()
	{
		return repo.findAll();
	}

}
