package com.employee;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmpPayrollFileIO {
	public static final String PAYROLL_FILE_NAME = "/Users/ankithakamath/Desktop/assignments/Emppayroll/src/main/java/com/employee/PayrollData.txt";

	/**
	 * method to Write Employee Payroll to a File
	 */
	public void writeData(List<EmpPayrollData> empPayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		empPayrollList.forEach(emp -> {
			String empDataString = emp.toString().concat("\n");
			empBuffer.append(empDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   /*
    * Employee Payroll to get count
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
}
