package com.group4.backend.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class DemoUser {
	private BigDecimal id;
	private String name;
	private String pass;
	private Date createdAt;
	private Date updatedAt;
	private BigDecimal status;

	@Override
	public String toString() {
		return "DemoUser{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pass='" + pass + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", status=" + status +
				'}';
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}
}
