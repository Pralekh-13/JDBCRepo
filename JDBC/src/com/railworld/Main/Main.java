package com.railworld.Main;

import java.util.List;
import java.util.Scanner;

import com.railworld.dao.EmployeeDao;
import com.railworld.model.Employee;
import com.railworld.service.EmployeeService;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static EmployeeService employeeService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeDao employeeDAO = new EmployeeDao();
		employeeService = new EmployeeService(employeeDAO);

		while (true) {
			System.out.println("1. View all employees");
			System.out.println("2. Add new employee");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				viewAllEmployees();
				break;

			case 2:
				addEmployee();
				break;

			case 3:
				updateEmployee();
				break;

			case 4:
				deleteEmployee();
				break;

			case 5:
				System.out.println("Exiting the program");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void viewAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();

		System.out.println("Employee List:");

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private static void addEmployee() {
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();

		System.out.print("Enter employee designation: ");
		String designation = scanner.nextLine();

		Employee employee = new Employee(0, name, designation);
		employeeService.addEmployee(employee);

		System.out.println("Employee added successfully!");
	}

	private static void updateEmployee() {

		System.out.print("Enter the ID of the employee to update: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		System.out.print("Enter new name: ");
		String name = scanner.nextLine();

		System.out.print("Enter new designation: ");
		String designation = scanner.nextLine();

		Employee employee = new Employee(id, name, designation);
		employeeService.updateEmployee(employee);

		System.out.println("Employee updated successfully!");
	}

	private static void deleteEmployee() {
		System.out.print("Enter the ID of the employee to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		employeeService.deleteEmployee(id);

		System.out.println("Employee deleted successfully!");
	}

}
