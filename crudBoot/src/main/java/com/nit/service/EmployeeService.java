package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;
import java.util.*;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> showAll(){
		return repo.findAll();
	}
	
public Employee findById(int id)
{
	return repo.findById(id).get();
}

public List<Employee> findByName(String nm)
{
	return repo.findByName(nm);
}

public void save(Employee emp)
{
	repo.save(emp);
}

public void upd(String nm)
{
	repo.findByNa(nm);
}

public void del(int name)
{
	repo.deleteById(name);
}
}
