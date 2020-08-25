package com.group4.backend.entity;

import oracle.sql.DATE;
import oracle.sql.NUMBER;

import java.math.BigDecimal;
import java.sql.Date;

public class Employee {
	private BigDecimal employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private BigDecimal salary;
	private BigDecimal commissionPct;
	private BigDecimal managerId;
	private BigDecimal departmentId;

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", hireDate=" + hireDate +
				", jobId='" + jobId + '\'' +
				", salary=" + salary +
				", commissionPct=" + commissionPct +
				", managerId=" + managerId +
				", departmentId=" + departmentId +
				'}';
	}
}
