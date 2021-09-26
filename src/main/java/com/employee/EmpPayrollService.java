package com.employee;

import java.util.*;

public class EmpPayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	public List<EmpPayrollData> employeePayrollList;

	public EmpPayrollService() {
		System.out.println("Welcome to Employee Payroll Service.");
	}

	public EmpPayrollService(List<EmpPayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/*
	 * method to read employee detail from the user
	 */
	public void writeEmployeePayrollData(EmpPayrollService.IOService fileIo) {
		if (fileIo.equals(IOService.CONSOLE_IO)) {
			System.out.println("\n Writing Employee Payroll Roaster to Console\n" + employeePayrollList);
		} else if (fileIo.equals(IOService.FILE_IO)) {
			new EmpPayrollFileIO().writeData(employeePayrollList);
		}
	}
	public long countEntries(IOService ioService)
	{  
        return new EmpPayrollFileIO().countEntries();
    }
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
	 * method to print employee detail to the console
	 */
	private void writeEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("\nWriting Employee Payroll to Console \n" + employeePayrollList);
	}

	public static void main(String[] args) {
		ArrayList<EmpPayrollData> employeePayrollList = new ArrayList<>();
		EmpPayrollService employeePayrollService = new EmpPayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		consoleInputReader.close();
	}
}