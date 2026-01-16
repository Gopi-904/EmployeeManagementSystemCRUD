package curd.employee.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import curd.employee.entity.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Long>{

}
