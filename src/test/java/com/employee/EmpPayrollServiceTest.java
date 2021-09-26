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
		EmpPayrollData[] arrayOfEmps = { new EmpPayrollData(" Jeff", 1, 100000.0),
				new EmpPayrollData("Bill", 2, 200000.0), new EmpPayrollData("Mark", 3, 300000.0) };
		EmpPayrollService employeePayrollService;
		employeePayrollService = new EmpPayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmpPayrollService.IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(EmpPayrollService.IOService.FILE_IO);
		assertEquals(3, entries);
	}
}