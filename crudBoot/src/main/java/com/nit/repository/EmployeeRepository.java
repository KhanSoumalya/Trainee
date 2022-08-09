package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.entity.Employee;


import java.util.*;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value="select * from Employee where name like %?1%",nativeQuery = true)
	List<Employee> findByName(String inputString);
	
	@Query(value="delete from Employee where name like ?1",nativeQuery = true)
String findByNa(String name);

}
