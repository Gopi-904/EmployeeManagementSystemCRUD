package curd.employee.service;

import java.util.List;

import curd.employee.entity.Employee;

public interface EmployeeServices {
	void createNewEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(Long id);
	Employee searchEmployee(Long id);
	List<Employee> getAllEmployees();
	void deleteById(int id);
}
