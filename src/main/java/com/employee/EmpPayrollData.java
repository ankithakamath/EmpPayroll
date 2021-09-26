package com.employee;

public class EmpPayrollData {

	private int id;
	private String name;
	private double salary;

	public EmpPayrollData(String name, int id, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " salary:" + salary;
	}

}
