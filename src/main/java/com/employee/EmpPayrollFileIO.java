package com.employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmpPayrollFileIO {
	public static final String PAYROLL_FILE_NAME = "/Users/ankithakamath/Desktop/assignments/Emppayroll/src/main/java/com/employee/PayrollData.txt";

	/**
	 * method to Write Employee Payroll to a File
	 */
	public void writeData(List<EmpPayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * to get count of entries of employee payroll
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	/*
	 * to print payroll entries from file
	 */
	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * method to read employee payroll data from file
	 */
	public List<EmpPayrollData> readData() {
		List<EmpPayrollData> employeePayrollList = new ArrayList<>();
		try {
			Files.lines((new File(PAYROLL_FILE_NAME).toPath())).map(line -> line.trim()).forEach(line -> {
				String[] s = line.split(",");
				employeePayrollList.add(new EmpPayrollData(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2])));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
