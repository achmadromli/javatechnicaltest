package com.softwareseni.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	private Long transactionId;
	
	private String type;
	
	private Double amount;
	
	private Long parentId;
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
