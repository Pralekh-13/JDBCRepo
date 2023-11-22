package com.railworld.service;

import java.util.List;

import com.railworld.dao.EmployeeDao;
import com.railworld.model.Employee;

public class EmployeeService {
	private EmployeeDao employeeDAO;

	public EmployeeService(EmployeeDao employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
}
