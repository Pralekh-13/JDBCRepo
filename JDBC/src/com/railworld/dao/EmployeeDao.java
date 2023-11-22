package com.railworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.railworld.model.Employee;

public class EmployeeDao {

	private static final String URL = "jdbc:mysql://localhost:3306/yourdatabase";
	private static final String USER = "yourusername";
	private static final String PASSWORD = "yourpassword";

	private Connection connection;

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try {
			String query = "SELECT * FROM employees";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getString("designation"));
					employees.add(employee);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public void addEmployee(Employee employee) {
		try {
			String query = "INSERT INTO employees (name, designation) VALUES (?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getDesignation());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee employee) {
		try {
			String query = "UPDATE employees SET name = ?, designation = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getDesignation());
				statement.setInt(3, employee.getId());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int employeeId) {
		try {
			String query = "DELETE FROM employees WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeId);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
