package com.employee;

public class EmpPayrollData {

	private int id;
	private String name;
	private double salary;

	public EmpPayrollData(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return  " name:" + name +"id:" + id + " salary:" + salary;
	}

}
