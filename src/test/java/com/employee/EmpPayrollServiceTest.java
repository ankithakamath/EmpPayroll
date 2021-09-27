package com.employee;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Employee Payroll Service Test to check the file outputs
 */
public class EmpPayrollServiceTest {
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmpPayrollData[] arrayOfEmps = { new EmpPayrollData(" Sun", 001, 19000.0),
				new EmpPayrollData("moon", 002, 21000.0), new EmpPayrollData("star", 003, 45000.0) };
		EmpPayrollService employeePayrollService;
		employeePayrollService = new EmpPayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmpPayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmpPayrollService.IOService.FILE_IO);
		assertEquals(3, entries);
	}
	@Test
	public void given3EmployeesReadFromFile() {

		EmpPayrollService employeePayrollService = new EmpPayrollService();
		long x = employeePayrollService.readEmployeePayrollData();
		assertEquals(3, x);
	}

}


