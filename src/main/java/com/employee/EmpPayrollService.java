package com.employee;

import java.util.*;

public class EmpPayrollService {

	private List<EmpPayrollData> employeePayrollList;

	public EmpPayrollService() {
		System.out.println("Welcome to Employee Payroll Service.");
	}

	public EmpPayrollService(List<EmpPayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/*
	 * To read the employee id, name and salary amount
	 */
	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter employee name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter employee salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmpPayrollData(name, id, salary));
	}

	/*
	 * Printing the employee details like name,id and salary amount
	 */
	private void writeEmpPayrollData(Scanner consoleInputReader) {
		System.out.println("\nWriting Employee Payroll to Console \n" + employeePayrollList);
	}

	public static void main(String[] args) {
		ArrayList<EmpPayrollData> employeePayrollList = new ArrayList<EmpPayrollData>();
		EmpPayrollService employeePayrollService = new EmpPayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmpPayrollData(consoleInputReader);
		consoleInputReader.close();
	}
}