package com.sbi.controller.domain;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
public class Investment {

	private Long id;
	private String type;
	private double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
