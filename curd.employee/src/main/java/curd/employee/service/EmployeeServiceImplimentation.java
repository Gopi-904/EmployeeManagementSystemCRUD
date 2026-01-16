package curd.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curd.employee.entity.Employee;
import curd.employee.repositry.EmployeeRepositry;

@Service
public class EmployeeServiceImplimentation implements EmployeeServices {
	@Autowired
	EmployeeRepositry repo;

	@Override
	public void createNewEmployee(Employee emp) {
		repo.save(emp);
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		repo.save(emp);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public Employee searchEmployee(Long id) {
		 return repo.findById(id).get();
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}
